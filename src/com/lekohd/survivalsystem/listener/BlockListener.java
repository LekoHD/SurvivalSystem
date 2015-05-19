package com.lekohd.survivalsystem.listener;

import com.lekohd.survivalsystem.data.BlockDatabase;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Created by Leon on 17.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class BlockListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        if(!(event.getPlayer().isOp()))
        {
            if((event.getBlockPlaced().getState().getType() == Material.IRON_ORE) || (event.getBlockPlaced().getState().getType() == Material.DIAMOND_ORE) || (event.getBlockPlaced().getState().getType() == Material.GOLD_ORE) || (event.getBlockPlaced().getState().getType() == Material.EMERALD_ORE))
            {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        BlockDatabase.addPointsByBlock(event.getBlock().getTypeId(), event.getPlayer());
    }

}
