package me.taahanis.prpg.listeners;

import me.taahanis.prpg.PRPG;

public class Manager {

    public PRPG plugin;

    public Manager(PRPG instance)
    {
        this.plugin = instance;
    }

    public void register()
    {
        plugin.getServer().getPluginManager().registerEvents(new Picker(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AddScoreboard(), plugin);
    }

}
