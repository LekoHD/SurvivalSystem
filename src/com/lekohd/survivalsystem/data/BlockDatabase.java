package com.lekohd.survivalsystem.data;

import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.entity.Player;

/**
 * Created by Leon on 15.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2014 Leon167 { LekoHD
 */
public class BlockDatabase {

    public static void addPointsByBlock(int blockID, Player p)
    {
        switch (blockID)
        {
            case 1:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1); //Stone
                break;
            case 2:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1); //Grass
                break;
            case 3:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1); //Dirt
                break;
            case 4:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1); //Cobblestone
                break;
            case 12:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 2); //Sand
                break;
            case 13:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 3); //Gravel
                break;
            case 14:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 150); //Gold Ore
                break;
            case 15:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 40); //Iron Ore
                break;
            case 16:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 20); //Coal Ore
                break;
            case 17:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Oak Wood
                break;
            case 18:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1); //Leaves
                break;
            case 21:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 175); //Lapis Lazuli Ore
                break;
            case 24:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 10); //Sandstone
                break;
            case 48:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 100); //Moss Stone
                break;
            case 49:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 200); //Obsidian
                break;
            case 52:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 300); //Monster Spawner
                break;
            case 56:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 500); //Diamond Ore
                break;
            case 73:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 150); //Redstone Ore
                break;
            case 74:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 150); //Redstone Ore
                break;
            case 81:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 15); //Cactus
                break;
            case 82:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Clay Block
                break;
            case 83:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 10); //Sugar Cane
                break;
            case 86:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 15); //Pumpkin
                break;
            case 87:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 2); //Netherrack
                break;
            case 88:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 3); //Soul Sand
                break;
            case 89:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 3); //Glowstone Block
                break;
            case 103:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 15); //Melon
                break;
            case 110:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 3); //Mycelium
                break;
            case 112:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 3); //Nether Brick
                break;
            case 121:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 2); //End Stone
                break;
            case 122:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1000000); //Dragon Egg
                break;
            case 127:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Cocoa Plant
                break;
            case 129:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 750); //Emerald Ore
                break;
            case 153:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 50); //Nether Quartz Ore
                break;
            case 161:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 1); //Acacia Leaves
                break;
            case 162:
                SurvivalSystem.statisticManager.addPlayerPoints(p, 5); //Acacia Wood
                break;
            default: break;
        }
    }

}
