package me.taahanis.prpg.listeners;

import me.taahanis.prpg.PRPG;
import me.taahanis.prpg.race.Race;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.*;

public class Picker implements Listener {

    public PRPG plugin = PRPG.getPlugin(PRPG.class);
    public static final String GUINAME = ChatColor.RED + "Race Selector";
    Inventory inv = Bukkit.getServer().createInventory(null, 9, GUINAME);
    BukkitTask openInv;

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        final Player player = event.getPlayer();

        if (!plugin.creator.check(player))
        {
            openInv = new BukkitRunnable() {
                public void run() {
                    player.openInventory(inv);
                    Elf();
                    Human();
                    Wizard();
                }
            }.runTaskLater(plugin, 60); //3 seconds
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        Inventory i = event.getClickedInventory();
        ItemStack is = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (i.getName().equals(GUINAME)) //i hate deprecated but WHATEVEr
        {

            if (is != null)
            {

                if (is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Elf"))
                {
                    plugin.creator.create(p, Race.ELF.getName());
                    p.sendMessage(ChatColor.GREEN + "You are now an ELF.");
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    plugin.scoreboardM.setSB(p);
                    p.closeInventory();
                    return;
                }

                if (is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Human"))
                {
                    plugin.creator.create(p, Race.HUMAN.getName());
                    p.sendMessage(ChatColor.GREEN + "You are now a HUMAN.");
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    plugin.scoreboardM.setSB(p);
                    p.closeInventory();
                    return;
                }

                if (is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Wizard"))
                {
                    plugin.creator.create(p, Race.HUMAN.getName());
                    p.sendMessage(ChatColor.GREEN + "You are now a WIZARD.");
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    plugin.scoreboardM.setSB(p);
                    p.closeInventory();
                    return;
                }

            }

        }
    }

    public void Elf()
    {
        ItemStack item = new ItemStack(Material.MOSSY_COBBLESTONE_WALL, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.GREEN + "Elf");
        }
        item.setItemMeta(meta);
        inv.setItem(2, item); //0,1,(2),3,4,5,6,7,8
    }
    public void Human()
    {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.GREEN + "Human");
        }
        item.setItemMeta(meta);
        inv.setItem(5, item); //0,1,2,3,4,(5),6,7,8
    }
    public void Wizard()
    {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.addEnchant(Enchantment.FROST_WALKER, 5,true);
            meta.setDisplayName(ChatColor.GREEN + "Wizard");
        }
        item.setItemMeta(meta);
        inv.setItem(8, item); //0,1,2,3,4,5,6,7,(8)
    }



}
