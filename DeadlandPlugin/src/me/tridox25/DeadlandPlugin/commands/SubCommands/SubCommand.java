package me.tridox25.DeadlandPlugin.commands.SubCommands;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    public SubCommand() {

    }


    public abstract void onCommand(Player player, String[] args);

    public abstract String name();
    public abstract String info();

    public abstract String version();

    public abstract String[] aliases();
}

