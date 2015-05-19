package com.lekohd.survivalsystem.manager;

import com.lekohd.economysystem.EconomySystem;
import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Leon on 14.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class StatisticManager {

    public static FileConfiguration data;
    public static HashMap<UUID, Integer> playerStats = new HashMap<UUID, Integer>();
    public static HashMap<UUID, Integer> playerStartStats = new HashMap<UUID, Integer>();
    public static HashMap<UUID, String> playerGroup = new HashMap<UUID, String>();
    public static ArrayList<String> players;

    public StatisticManager()
    {
        data = SurvivalSystem.settingsManager.getData();
    }

    public static void load()
    {
        players = (ArrayList) data.getList("ListedPlayers");
        if(players != null)
        {
            for(String uuid : players)
            {
                if(!playerStats.containsKey(UUID.fromString(uuid))) {
                    playerStats.put(UUID.fromString(uuid), data.getInt("players." + uuid + ".points"));
                    playerStartStats.put(UUID.fromString(uuid), data.getInt("players." + uuid + ".points"));
                }
                if(!playerGroup.containsKey(UUID.fromString(uuid)))
                    playerGroup.put(UUID.fromString(uuid), data.getString("players." + uuid + ".group"));
            }
        }
        else
        {
            players = new ArrayList<String>();
        }
    }

    public static void addPlayer(Player p)
    {
        if(!players.contains(p.getUniqueId().toString()))
        {
            String uuid = p.getUniqueId().toString();
            players.add(uuid);
            if(data.getList("ListedPlayers") == null)
            {
                ArrayList<String> a = new ArrayList<String>();
                a.add(uuid);
                data.set("ListedPlayers", a);
                if(!playerStats.containsKey(p.getUniqueId()))
                {
                    playerStats.put(p.getUniqueId(), 1);
                    playerStartStats.put(p.getUniqueId(), 1);
                    data.set("players." + uuid + ".points", 1);
                }
                if(!playerGroup.containsKey(p.getUniqueId()))
                {
                    playerGroup.put(p.getUniqueId(), SurvivalSystem.rankManager.getDefaultGroup());
                    data.set("players." + uuid + ".group", SurvivalSystem.rankManager.getDefaultGroup());
                    PermissionUser user = PermissionsEx.getUser(p);
                    user.addGroup(SurvivalSystem.rankManager.getDefaultGroup());
                }
            } else
            if(!data.getList("ListedPlayers").contains(uuid))
            {
                ArrayList<String> a = (ArrayList) data.getList("ListedPlayers");
                a.add(uuid);
                data.set("ListedPlayers", a);

            }
            if(!playerStats.containsKey(p.getUniqueId()))
            {
                playerStats.put(p.getUniqueId(), 1);
                playerStartStats.put(p.getUniqueId(), 1);
                data.set("players." + uuid + ".points", 1);
            }
            if(!playerGroup.containsKey(p.getUniqueId()))
            {
                playerGroup.put(p.getUniqueId(), SurvivalSystem.rankManager.getDefaultGroup());
                data.set("players." + uuid + ".group", SurvivalSystem.rankManager.getDefaultGroup());
                PermissionUser user = PermissionsEx.getUser(p);
                user.addGroup(SurvivalSystem.rankManager.getDefaultGroup());
            }
            SurvivalSystem.settingsManager.saveData();
        }
    }

    public static void updatePlayerStats(Player p, int value)
    {
        playerStats.put(p.getUniqueId(), value);
    }

    public static void addPlayerPoints(Player p, int value)
    {
        playerStats.put(p.getUniqueId(), playerStats.get(p.getUniqueId()) + value);
        checkPlayerPoints(p);


    }

    public static void saveAllStats(boolean shutdown)
    {
        data.set("ListedPlayers", players);
        for(String uuid : players)
        {
            data.set("players." + uuid + ".points", playerStats.get(UUID.fromString(uuid)));
            data.set("players." + uuid + ".group", playerGroup.get(UUID.fromString(uuid)));
        }
        SurvivalSystem.settingsManager.saveData();
        if(shutdown)
        {
            for(String uuid : players) {
                if (SurvivalSystem.isEconomyEnabled) {
                    if(EconomySystem.hasConnection())
                    {
                        int value = SurvivalSystem.statisticManager.playerStats.get(UUID.fromString(uuid));
                        int before = SurvivalSystem.statisticManager.playerStartStats.get(UUID.fromString(uuid));
                        int after = value - before;
                        if(after > 9)
                        {
                            int amount = (after/10);
                            EconomySystem.addCoins(Bukkit.getPlayer(UUID.fromString(uuid)), (int)amount);
                        }
                    }
                }
            }
        }
    }

    public static void checkPlayerPoints(Player p)
    {
        int points = playerStats.get(p.getUniqueId());
        int[] rankValues = SurvivalSystem.rankManager.getRankValues();
        for (int i = 0; i < rankValues.length; i++)
        {
            if(points == rankValues[i])
            {
                if(playerGroup.get(p.getUniqueId()).equalsIgnoreCase((String)SurvivalSystem.rankManager.getRanks().get(rankValues[i])))
                    return;
                setPlayerGroup(p, (String)SurvivalSystem.rankManager.getRanks().get(rankValues[i]), (String)SurvivalSystem.rankManager.getRanks().get(rankValues[i-1]));
                p.sendMessage("§8Herzlichen Glückwunsch! Du hast nun den Rang §3" + (String)SurvivalSystem.rankManager.getRanks().get(rankValues[i]));
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 5, 5);
                p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 2004);
                return;
            }
            if(points < rankValues[i])
            {
                if(playerGroup.get(p.getUniqueId()).equalsIgnoreCase((String)SurvivalSystem.rankManager.getRanks().get(rankValues[i-1])))
                    return;
                setPlayerGroup(p, (String)SurvivalSystem.rankManager.getRanks().get(rankValues[i-1]), (String)SurvivalSystem.rankManager.getRanks().get(rankValues[i-2]));
                p.sendMessage("§8Herzlichen Glückwunsch! Du hast nun den Rang §3" + (String)SurvivalSystem.rankManager.getRanks().get(rankValues[i-1]));
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 5, 5);
                p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 2004);
                return;
            }
            if(points > rankValues[rankValues.length - 1])
            {
                if(playerGroup.get(p.getUniqueId()).equalsIgnoreCase((String)SurvivalSystem.rankManager.getRanks().get(rankValues[rankValues.length - 1])))
                    return;
                setPlayerGroup(p, (String)SurvivalSystem.rankManager.getRanks().get(rankValues[rankValues.length - 1]), (String)SurvivalSystem.rankManager.getRanks().get(rankValues[rankValues.length - 2]));
                p.sendMessage("§8Herzlichen Glückwunsch! Du hast nun den Rang §3" + (String)SurvivalSystem.rankManager.getRanks().get(rankValues[rankValues.length - 1]));
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 5, 5);
                p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 2004);
                return;
            }
        }
    }

    public static void setPlayerGroup(Player p, String group, String oldGroup)
    {
        playerGroup.put(p.getUniqueId(), group);
        PermissionUser user = PermissionsEx.getUser(p);
        user.addGroup(group);
        user.removeGroup(oldGroup);
    }

}
