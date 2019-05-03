package me.taahanis.prpg;

import me.taahanis.prpg.config.Config;
import me.taahanis.prpg.config.ConfigsControl;
import me.taahanis.prpg.config.PlayerConfig;
import me.taahanis.prpg.listeners.Manager;
import me.taahanis.prpg.player.Creator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PRPG extends JavaPlugin {

    public Manager listenerManager;
    public Creator creator;
    public ScoreboardManage scoreboardM;

    public ConfigsControl controller;
    public Config config;
    public PlayerConfig playerConfig;

    public String prefix = "[" + getDescription().getName() + "] ";
    public String version = getDescription().getVersion();

    @Override
    public void onLoad()
    {
        this.controller = new ConfigsControl(this);
        this.config = new Config(this);
        this.playerConfig = new PlayerConfig(this);
        this.listenerManager = new Manager(this);
        this.creator = new Creator(this);
        this.scoreboardM = new ScoreboardManage(this);

        controller.create(); //this function checks if the directory exists and if not, creates it
        config.setup();
        playerConfig.setup();

        Bukkit.getLogger().info(ChatColor.GREEN + prefix + "LOADING - VERSION " + version);

    }

    @Override
    public void onEnable()
    {

        listenerManager.register();

        Bukkit.getLogger().info(ChatColor.GREEN + prefix + "ENABLED - VERSION " + version);
    }

    @Override
    public void onDisable()
    {
        Bukkit.getLogger().info(ChatColor.GREEN + prefix + "DISABLED - VERSION " + version);
    }

}
