package me.taahanis.prpg.config;

import me.taahanis.prpg.PRPG;

public class ConfigsControl {

    PRPG plugin;

    public ConfigsControl(PRPG instance)
    {
        this.plugin = instance;
    }

    public void create()
    {
        if (!plugin.getDataFolder().exists())
        {
            plugin.getDataFolder().mkdir();
        }
    }
}
