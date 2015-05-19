package com.lekohd.survivalsystem.data;

import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Created by Leon on 15.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class MobDatabase {

    public static void addPointsByKilledMob(Entity killed, Player p)
    {
        int mobID = killed.getType().getTypeId();
        //p.sendMessage(mobID + "");
        switch (mobID)
        {
            case 50:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Creeper
                break;
            case 51:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Skeleton
                break;
            case 52:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Spider
                break;
            case 53:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1000); //Giant
                break;
            case 54:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Zombie
                break;
            case 55:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Slime
                break;
            case 56:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 200); //Ghast
                break;
            case 57:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 30); //Zombie Pigman
                break;
            case 58:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 100); //Enderman
                break;
            case 59:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Cave Spider
                break;
            case 60:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 30); //Silverfish
                break;
            case 61:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 100); //Blaze
                break;
            case 62:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 150); //Magma Cube
                break;
            case 63:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 10000); //Ender Dragon
                break;
            case 64:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20000); //Wither
                break;
            case 66:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 30); //Witch
                break;
            case 67:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 50); //Endermite
                break;
            case 68:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 150); //Guardian
                break;
            case 101:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Rabbit
                break;
            case 65:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 3); //Bat
                break;
            case 90:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Pig
                break;
            case 91:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Sheep
                break;
            case 92:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Cow
                break;
            case 93:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Chicken
                break;
            case 94:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Squid
                break;
            case 95:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Wolf
                break;
            case 96:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Mushroom Cow
                break;
            case 97:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 10); //Snow Golem
                break;
            case 98:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Ozelot
                break;
            case 99:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 50); //Iron Golem
                break;
            case 100:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Horse
                break;
            case 120:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Villager
                break;
            default: break;
        }
    }

}
