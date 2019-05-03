package me.taahanis.prpg.listeners;

import me.taahanis.prpg.PRPG;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AddScoreboard implements Listener {

    PRPG plugin = PRPG.getPlugin(PRPG.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        if (player.hasPlayedBefore() && plugin.creator.check(player))
        {
            plugin.scoreboardM.setSB(player);
        }
    }
}
