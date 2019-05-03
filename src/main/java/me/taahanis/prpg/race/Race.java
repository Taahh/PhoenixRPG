package me.taahanis.prpg.race;

import me.taahanis.prpg.PRPG;
import org.bukkit.entity.Player;

public enum Race {

    LONER("LONER"),
    ELF("ELF"),
    WIZARD("WIZARD"),
    HUMAN("HUMAN");

    String n;
    private Race(String n)
    {
        this.n = n;
    }

    public static boolean isElf(Player player)
    {
        return PRPG.getPlugin(PRPG.class).playerConfig.getConfig().getString(player.getUniqueId().toString() + ".race").equalsIgnoreCase(ELF.getName());
    }
    public static boolean isHuman(Player player)
    {
        return PRPG.getPlugin(PRPG.class).playerConfig.getConfig().getString(player.getUniqueId().toString() + ".race").equalsIgnoreCase(HUMAN.getName());
    }
    public static boolean isWizard(Player player)
    {
        return PRPG.getPlugin(PRPG.class).playerConfig.getConfig().getString(player.getUniqueId().toString() + ".race").equalsIgnoreCase(WIZARD.getName());
    }

    public static Race getRace(Player player)
    {
        if (isElf(player))
        {
            return ELF;
        }
        else if (isHuman(player))
        {
            return HUMAN;
        }
        else if (isWizard(player))
        {
            return WIZARD;
        }
        return LONER;
    }

    public String getName() {
        return n;
    }
}
