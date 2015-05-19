package com.lekohd.survivalsystem.listener;

import com.lekohd.economysystem.EconomySystem;
import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;

/**
 * Created by Leon on 15.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class LeaveListener implements Listener {

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event)
    {
        Player p = event.getPlayer();
        SurvivalSystem.statisticManager.saveAllStats(false);
        if(SurvivalSystem.isEconomyEnabled)
        {
            if(EconomySystem.hasConnection())
            {
                int value = SurvivalSystem.statisticManager.playerStats.get(p.getUniqueId());
                int before = SurvivalSystem.statisticManager.playerStartStats.get(p.getUniqueId());
                int after = value - before;
                if(after > 9)
                {
                    int amount = (after/10);
                    EconomySystem.addCoins(p, (int)amount);
                }
            }
        }
    }

}
