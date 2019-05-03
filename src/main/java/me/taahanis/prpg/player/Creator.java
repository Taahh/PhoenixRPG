package me.taahanis.prpg.player;

import me.taahanis.prpg.PRPG;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Creator {

    public PRPG plugin;

    public Creator(PRPG instance)
    {
        this.plugin = instance;
    }

    public boolean check(Player player)
    {
        String uuid = player.getUniqueId().toString();
        String checker = plugin.playerConfig.getConfig().getString(uuid);
        if (checker == null)
        {
            return false;
        }
        return true;
    }

    public void create(Player player, String race)
    {
        String uuid = player.getUniqueId().toString();
        FileConfiguration conf = plugin.playerConfig.getConfig();
        conf.createSection(uuid);
        conf.set(uuid + ".name", player.getName());
        conf.set(uuid + ".race", race);
        plugin.playerConfig.save();
    }
}
