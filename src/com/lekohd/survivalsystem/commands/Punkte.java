package com.lekohd.survivalsystem.commands;

import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Leon on 19.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class Punkte implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player)sender;
            if(!p.hasPermission("survivalsystem.punkte"))
                return true;
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
                        return true;
                    }
                    if(points == rankValues[i])
                    {
                        p.sendMessage("§8Deine Punkte: §3" + points);
                        p.sendMessage("§8Nächster Rang: §3" + SurvivalSystem.rankManager.ranks.get(rankValues[i+1]));
                        p.sendMessage("§8Punkte Benötigt: §3" + rankValues[i+1]);
                        return true;
                    }
                }
                else if(points < rankValues[i])
                {
                    p.sendMessage("§8Deine Punkte: §3" + points);
                    p.sendMessage("§8Nächster Rang: §3" + SurvivalSystem.rankManager.ranks.get(rankValues[i]));
                    p.sendMessage("§8Punkte Benötigt: §3" + rankValues[i]);
                    return true;
                }

            }
            p.sendMessage("§8Deine Punkte: §3" + points);
            p.sendMessage("§8Nächster Rang: §3");

        }
        return true;
    }

}
