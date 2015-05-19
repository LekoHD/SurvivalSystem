package com.lekohd.survivalsystem.manager;

import com.lekohd.survivalsystem.SurvivalSystem;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

/**
 * Created by Leon on 14.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2015 Leon167 { LekoHD
 */
public class RankManager {

    public static String[] survivalRanks;
    public static int[] rankVal;
    public static HashMap<Integer, String> ranks = new HashMap<Integer, String>();
    public static HashMap<String, String> rankPrefix = new HashMap<String, String>();
    public static RankManager instance = new RankManager();
    private String groups;

    public RankManager()
    {
        groups = SurvivalSystem.settingsManager.getConfig().getString("SurvivalRanks");
        survivalRanks = groups.split("\\|");
        rankVal = new int[survivalRanks.length];
    }

    public static RankManager getInstance()
    {
        return instance;
    }

    public void setupValues()
    {
        FileConfiguration config = SurvivalSystem.settingsManager.getConfig();
        config.set("SurvivalRanks", groups);
        for(int i = 0; i<survivalRanks.length;i++)
        {
            if(!(config.getInt(survivalRanks[i] + ".punkte")>0))
            {
                if(i == 0) {
                    config.set(survivalRanks[i] + ".punkte", 1);
                }
                else
                {
                    config.set(survivalRanks[i] + ".punkte", i * 10);
                }
            }
            if(!(config.getString(survivalRanks[i] + ".prefix") == ""))
            {
                config.set(survivalRanks[i] + ".prefix", "[" + survivalRanks[i] + "]");
            }
        }
        SurvivalSystem.settingsManager.saveConfig();
    }

    public void loadValues()
    {
        FileConfiguration config = SurvivalSystem.settingsManager.getConfig();
        for(int i = 0; i<survivalRanks.length;i++)
        {
            if(config.getInt(survivalRanks[i] + ".punkte")>0)
            {
                ranks.put(config.getInt(survivalRanks[i] + ".punkte"), survivalRanks[i]);
                rankPrefix.put(survivalRanks[i], config.getString(survivalRanks[i] + ".prefix"));
                rankVal[i] = config.getInt(survivalRanks[i] + ".punkte");
            }
            else
            {
                this.setupValues();
                SurvivalSystem.messageManager.log("Config wurde nicht richtig eingerichtet (SurvivalRank " + survivalRanks[i] + ")");
                return;
            }
        }
    }

    public int getGroupAmount()
    {
        return survivalRanks.length;
    }

    public static String getDefaultGroup()
    {
        return survivalRanks[0];
    }

    public static HashMap getRanks()
    {
        return ranks;
    }

    public static int[] getRankValues()
    {
        return rankVal;
    }

}
