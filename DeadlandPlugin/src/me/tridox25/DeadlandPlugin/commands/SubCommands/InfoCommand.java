package me.tridox25.DeadlandPlugin.commands.SubCommands;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class InfoCommand extends SubCommand {
    private Main plugin = Main.getInstance();


    @Override
    public void onCommand(Player player, String[] args) {
        player.sendMessage("--------------- Info ---------------");
        player.sendMessage("dpl discord: " + ChatColor.YELLOW + "Link al discord official");
        player.sendMessage("dpl version: " + ChatColor.YELLOW + "Version del plugin");
        player.sendMessage("-----------------------------------");
    }

    @Override
    public String name() {
        return "info";
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String version() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
