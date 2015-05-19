package com.lekohd.survivalsystem.listener;

import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.Achievement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

/**
 * Created by Leon on 18.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class AchievementListener implements Listener{

    @EventHandler
    public void onAchievement(PlayerAchievementAwardedEvent event)
    {
        int i = this.getAchievementPoints(event.getAchievement(), event.getPlayer());
        SurvivalSystem.statisticManager.addPlayerPoints(event.getPlayer(), i);
    }

    public int getAchievementPoints(Achievement a, Player p)
    {
        if(a == Achievement.OPEN_INVENTORY)
        {
            p.sendMessage("§8Du bekommst §310 §8Punkte für das Achievement.");
            return 10;
        }
        if(a == Achievement.MINE_WOOD)
        {
            p.sendMessage("§8Du bekommst §320 §8Punkte für das Achievement.");
            return 20;
        }
        if(a == Achievement.BUILD_WORKBENCH)
        {
            p.sendMessage("§8Du bekommst §350 §8Punkte für das Achievement.");
            return 50;
        }
        if(a == Achievement.BUILD_HOE)
        {
            p.sendMessage("§8Du bekommst §3100 §8Punkte für das Achievement.");
            return 100;
        }
        if(a == Achievement.BAKE_CAKE)
        {
            p.sendMessage("§8Du bekommst §31000 §8Punkte für das Achievement.");
            return 1000;
        }
        if(a == Achievement.MAKE_BREAD)
        {
            p.sendMessage("§8Du bekommst §31000 §8Punkte für das Achievement.");
            return 1000;
        }
        if(a == Achievement.BUILD_PICKAXE)
        {
            p.sendMessage("§8Du bekommst §3100 §8Punkte für das Achievement.");
            return 100;
        }
        if(a == Achievement.BUILD_BETTER_PICKAXE)
        {
            p.sendMessage("§8Du bekommst §3200 §8Punkte für das Achievement.");
            return 200;
        }
        if(a == Achievement.OVERPOWERED)
        {
            p.sendMessage("§8Du bekommst §35000 §8Punkte für das Achievement.");
            return 5000;
        }
        if(a == Achievement.BUILD_FURNACE)
        {
            p.sendMessage("§8Du bekommst §3100 §8Punkte für das Achievement.");
            return 100;
        }
        if(a == Achievement.ACQUIRE_IRON)
        {
            p.sendMessage("§8Du bekommst §3200 §8Punkte für das Achievement.");
            return 200;
        }
        if(a == Achievement.COOK_FISH)
        {
            p.sendMessage("§8Du bekommst §3300 §8Punkte für das Achievement.");
            return 300;
        }
        if(a == Achievement.BUILD_SWORD)
        {
            p.sendMessage("§8Du bekommst §3100 §8Punkte für das Achievement.");
            return 100;
        }
        if(a == Achievement.KILL_ENEMY)
        {
            p.sendMessage("§8Du bekommst §3150 §8Punkte für das Achievement.");
            return 150;
        }
        if(a == Achievement.SNIPE_SKELETON)
        {
            p.sendMessage("§8Du bekommst §31000 §8Punkte für das Achievement.");
            return 1000;
        }
        if(a == Achievement.KILL_COW)
        {
            p.sendMessage("§8Du bekommst §3100 §8Punkte für das Achievement.");
            return 100;
        }
        if(a == Achievement.BREED_COW)
        {
            p.sendMessage("§8Du bekommst §3200 §8Punkte für das Achievement.");
            return 200;
        }
        if(a == Achievement.FLY_PIG)
        {
            p.sendMessage("§8Du bekommst §3500 §8Punkte für das Achievement.");
            return 500;
        }
        if(a == Achievement.ON_A_RAIL)
        {
            p.sendMessage("§8Du bekommst §3500 §8Punkte für das Achievement.");
            return 500;
        }
        if(a == Achievement.DIAMONDS_TO_YOU)
        {
            p.sendMessage("§8Du bekommst §3500 §8Punkte für das Achievement.");
            return 500;
        }
        if(a == Achievement.GET_DIAMONDS)
        {
            p.sendMessage("§8Du bekommst §31000 §8Punkte für das Achievement.");
            return 1000;
        }
        if(a == Achievement.ENCHANTMENTS)
        {
            p.sendMessage("§8Du bekommst §3750 §8Punkte für das Achievement.");
            return 750;
        }
        if(a == Achievement.OVERKILL)
        {
            p.sendMessage("§8Du bekommst §32000 §8Punkte für das Achievement.");
            return 2000;
        }
        if(a == Achievement.BOOKCASE)
        {
            p.sendMessage("§8Du bekommst §3300 §8Punkte für das Achievement.");
            return 300;
        }
        if(a == Achievement.NETHER_PORTAL)
        {
            p.sendMessage("§8Du bekommst §35000 §8Punkte für das Achievement.");
            return 5000;
        }
        if(a == Achievement.GHAST_RETURN)
        {
            p.sendMessage("§8Du bekommst §31000 §8Punkte für das Achievement.");
            return 1000;
        }
        if(a == Achievement.GET_BLAZE_ROD)
        {
            p.sendMessage("§8Du bekommst §31250 §8Punkte für das Achievement.");
            return 1250;
        }
        if(a == Achievement.BREW_POTION)
        {
            p.sendMessage("§8Du bekommst §37500 §8Punkte für das Achievement.");
            return 7500;
        }
        if(a == Achievement.THE_END)
        {
            p.sendMessage("§8Du bekommst §3100000 §8Punkte für das Achievement.");
            return 100000;
        }
        if(a == Achievement.END_PORTAL)
        {
            p.sendMessage("§8Du bekommst §310000 §8Punkte für das Achievement.");
            return 10000;
        }
        if(a == Achievement.EXPLORE_ALL_BIOMES)
        {
            p.sendMessage("§8Du bekommst §310000 §8Punkte für das Achievement.");
            return 10000;
        }
        if(a == Achievement.SPAWN_WITHER)
        {
            p.sendMessage("§8Du bekommst §320000 §8Punkte für das Achievement.");
            return 20000;
        }
        if(a == Achievement.KILL_WITHER)
        {
            p.sendMessage("§8Du bekommst §3200000 §8Punkte für das Achievement.");
            return 200000;
        }
        if(a == Achievement.FULL_BEACON)
        {
            p.sendMessage("§8Du bekommst §320000 §8Punkte für das Achievement.");
            return 20000;
        }
        return 0;
    }

}
