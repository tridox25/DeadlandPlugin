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

public class dpl implements CommandExecutor {

    @SuppressWarnings("unused")
    private Main plugin;

    public dpl(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("dpl").setExecutor(this);
    }

    public dpl() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("¡Solo los jugadores puede usar este comando!");
            return true;
        }

        Player p = (Player) sender;


        if (p.hasPermission("dpl.use")) {

            sender.sendMessage("-------------------- Dpl Commands ---------------");
            sender.sendMessage(ChatColor.ITALIC+""+ChatColor.RED+"dpl discord: "+ChatColor.YELLOW+"Link al discord official del plugin");







        } else {
            p.sendMessage("No tienes los permisos suficientes.");
        }
        return false;
    }
}