package com.lekohd.survivalsystem;


import com.lekohd.survivalsystem.commands.Punkte;
import com.lekohd.survivalsystem.listener.*;
import com.lekohd.survivalsystem.manager.MessageManager;
import com.lekohd.survivalsystem.manager.RankManager;
import com.lekohd.survivalsystem.manager.SettingsManager;
import com.lekohd.survivalsystem.manager.StatisticManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Leon on 14.05.2015.
 * Project SurvivalSystem
 * <p/>
 * Copyright (C) 2015 Leon167 { LekoHD
 */
public class SurvivalSystem extends JavaPlugin {

    public static SurvivalSystem instance;
    public static MessageManager messageManager;
    public static SettingsManager settingsManager;
    public static RankManager rankManager;
    public static StatisticManager statisticManager;
    public static boolean isEconomyEnabled;

    public void onEnable()
    {
        instance = this;

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(), this );
        pm.registerEvents(new LeaveListener(), this);
        pm.registerEvents(new MobListener(), this);
        pm.registerEvents(new BlockListener(), this);
        pm.registerEvents(new AchievementListener(), this);

        this.getCommand("punkte").setExecutor(new Punkte());

        messageManager = new MessageManager();
        messageManager.log("Version " + this.getDescription().getVersion() + " wird geladen.");
        messageManager.log("Von " + this.getDescription().getAuthors());

        settingsManager = new SettingsManager();
        settingsManager.setup(this);

        rankManager = new RankManager();
        rankManager.setupValues();
        rankManager.loadValues();

        statisticManager = new StatisticManager();
        statisticManager.load();

        isEconomyEnabled = pm.isPluginEnabled("EconomySystem");
    }

    public void onDisable()
    {
        messageManager.log("Speichert Spieler Daten.");
        statisticManager.saveAllStats(true);
        messageManager.log("Alle Daten gespeichert.");
    }

    public static SurvivalSystem getInstance()
    {
        return instance;
    }
}
