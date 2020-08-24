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

public class DplDiscord implements CommandExecutor {

    @SuppressWarnings("unused")
    private Main plugin;

    public DplDiscord(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("dpl discord").setExecutor(this);
    }

    public DplDiscord() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("¡Solo los jugadores puede usar este comando!");
            return true;
        }

        Player p = (Player) sender;


        if (p.hasPermission("dpl.use")) {

            sender.sendMessage(ChatColor.ITALIC+""+ChatColor.RED+"Link: "+ChatColor.YELLOW+"https://discord.gg/bhw2MHg");







        } else {
            p.sendMessage("No tienes los permisos suficientes.");
        }
        return false;
    }
}
