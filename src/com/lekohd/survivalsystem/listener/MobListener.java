package com.lekohd.survivalsystem.listener;

import com.lekohd.survivalsystem.SurvivalSystem;
import com.lekohd.survivalsystem.data.BlockDatabase;
import com.lekohd.survivalsystem.data.MobDatabase;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Created by Leon on 15.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class MobListener implements Listener {

    @EventHandler
    public void onMobSlainEvent(EntityDeathEvent event)
    {
        if(!(event.getEntity() instanceof Player))
        {
            Entity e = event.getEntity();

            if(e.getLastDamageCause() == null)
                return;

            if(!(e.getLastDamageCause() instanceof EntityDamageByEntityEvent))
                return;

            Entity killerEntity = ((EntityDamageByEntityEvent) e.getLastDamageCause()).getDamager();
            if(killerEntity instanceof Projectile)
            {
                Projectile projectile = (Projectile)killerEntity;
                if(!(projectile.getShooter() instanceof Player))
                    return;
                Player killer = (Player)projectile.getShooter();
                MobDatabase.addPointsByKilledMob(e, killer);
                return;
            }
            if(killerEntity instanceof Player)
            {
                Player killer = (Player) killerEntity;
                //killer.sendMessage("Killed Mob");
                MobDatabase.addPointsByKilledMob(e, killer);
            }
        }
    }
}
