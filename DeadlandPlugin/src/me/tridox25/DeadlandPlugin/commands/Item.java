package me.tridox25.DeadlandPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item implements CommandExecutor {

    @SuppressWarnings("unused")
    private Main plugin;

    public Item(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("item").setExecutor(this);
    }

    public Item() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("¡Solo los jugadores puede usar este comando!");
            return true;
        }

        Player p = (Player) sender;


        if (p.hasPermission("Hello.use")) {
            ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
            item.addEnchantment(Enchantment.DIG_SPEED, 5);
            item.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
            item.addEnchantment(Enchantment.MENDING, 100000);



            ItemMeta meta = item.getItemMeta();
            meta.setCustomModelData(123456);
            meta.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"Pico De Esmeralda");


            item.setItemMeta(meta);

            p.getInventory().addItem(item);
            return true;



        } else {
            p.sendMessage("No tienes los permisos suficientes.");
        }
        return false;
    }
}
