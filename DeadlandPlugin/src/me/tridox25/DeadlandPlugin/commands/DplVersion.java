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
import org.bukkit.plugin.PluginDescriptionFile;

public class DplVersion implements CommandExecutor {

    @SuppressWarnings("unused")
    private Main plugin;

    public DplVersion(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("dpl version").setExecutor(this);
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("¡Solo los jugadores puede usar este comando!");
            return true;
        }

        Player p = (Player) sender;


        if (p.hasPermission("dpl.use")) {



            sender.sendMessage(ChatColor.ITALIC+""+ChatColor.RED+"Version: "+ChatColor.YELLOW+"1.0-PRE-RELEASE");







        } else {
            p.sendMessage("No tienes los permisos suficientes.");
        }
        return false;
    }
}

