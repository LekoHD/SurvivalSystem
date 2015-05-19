package com.lekohd.survivalsystem.listener;

import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Leon on 15.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();
        SurvivalSystem.statisticManager.addPlayer(p);
        int points = SurvivalSystem.statisticManager.playerStats.get(p.getUniqueId());
        int[] rankValues = SurvivalSystem.rankManager.getRankValues();
        for (int i = 0; i < rankValues.length; i++)
        {
            if(points > rankValues[i] || points == rankValues[i])
            {
                if(rankValues[i] == rankValues[rankValues.length - 1])
                {
                    p.sendMessage("§8Deine Punkte: §3" + points);
                    p.sendMessage("§8Dein Rang: §3" + SurvivalSystem.statisticManager.playerGroup.get(p.getUniqueId()));
                    return;
                }
                if(points == rankValues[i])
                {
                    p.sendMessage("§8Deine Punkte: §3" + points);
                    p.sendMessage("§8Nächster Rang: §3" + SurvivalSystem.rankManager.ranks.get(rankValues[i+1]));
                    p.sendMessage("§8Punkte Benötigt: §3" + rankValues[i+1]);
                    return;
                }
            }
            else if(points < rankValues[i])
            {
                p.sendMessage("§8Deine Punkte: §3" + points);
                p.sendMessage("§8Nächster Rang: §3" + SurvivalSystem.rankManager.ranks.get(rankValues[i]));
                p.sendMessage("§8Punkte Benötigt: §3" + rankValues[i]);
                return;
            }

        }
        p.sendMessage("§8Deine Punkte: §3" + points);
        p.sendMessage("§8Nächster Rang: §3");
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event)
    {
        if(!event.getPlayer().hasPlayedBefore())
        {

        }
    }

}
