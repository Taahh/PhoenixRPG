package me.taahanis.prpg;

import me.taahanis.prpg.race.Race;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardManage {

    PRPG plugin;
    ScoreboardManager m;
    Scoreboard b;
    Objective o;
    public ScoreboardManage(PRPG instance)
    {
        this.plugin = instance;
        m = Bukkit.getServer().getScoreboardManager();
        b = m.getNewScoreboard();
    }
    public void setSB(Player player)
    {

        o = b.registerNewObjective("Stats", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Stats");

        Score empty = o.getScore(" ");
        empty.setScore(6);

        Score race = o.getScore("Race: " + Race.getRace(player).getName());
        race.setScore(5);

        player.setScoreboard(b);

    }


}
