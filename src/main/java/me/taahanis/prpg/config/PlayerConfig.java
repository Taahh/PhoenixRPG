package me.taahanis.prpg.config;

import me.taahanis.prpg.PRPG;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {
    PRPG plugin;
    File conf;
    YamlConfiguration configuration;
    public PlayerConfig(PRPG instance)
    {
        this.plugin = instance;
        this.conf = new File(plugin.getDataFolder(), "players.yml");
        this.configuration = YamlConfiguration.loadConfiguration(conf);
    }


    public FileConfiguration getConfig()
    {
        return configuration;
    }
    public void save()
    {
        try {
            configuration.save(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void reload()
    {
        try {
            configuration.load(conf);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void setup()
    {
        if (!conf.exists())
        {
            getConfig().options().copyDefaults(true);
            save();
            Bukkit.getLogger().info(ChatColor.GREEN + "Created players.yml - PHOENIX RPG");
        }
    }
}
