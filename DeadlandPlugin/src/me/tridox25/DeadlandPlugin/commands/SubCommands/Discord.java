package me.tridox25.DeadlandPlugin.commands.SubCommands;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Discord extends SubCommand {
    private Main plugin = Main.getInstance();


    @Override
    public void onCommand(Player player, String[] args) {
        player.sendMessage("Link Discord official: " + ChatColor.YELLOW + "https://discord.gg/bhw2MHg");
    }

    @Override
    public String name() {
        return "discord";
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

