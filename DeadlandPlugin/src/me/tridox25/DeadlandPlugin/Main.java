package me.tridox25.DeadlandPlugin;



import com.mojang.brigadier.Command;
import me.tridox25.DeadlandPlugin.commands.DplDiscord;
import me.tridox25.DeadlandPlugin.commands.DplVersion;
import me.tridox25.DeadlandPlugin.commands.Item;
import me.tridox25.DeadlandPlugin.commands.SubCommands.CommandManager;
import me.tridox25.DeadlandPlugin.commands.dpl;
import me.tridox25.DeadlandPlugin.customitems.EmeraldPickaxe;
import me.tridox25.DeadlandPlugin.customitems.EmeraldSword;
import me.tridox25.DeadlandPlugin.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    private long u;
    public CommandManager commandManager;
    private static Main instance;
    PluginDescriptionFile pdffile = getDescription();
    public String version = pdffile.getVersion();
    public String nombre = pdffile.getName();

    @Override
    public void onEnable() {
        setInstance(this);
        Bukkit.getConsoleSender().sendMessage("--------------------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+""+ChatColor.BOLD+" Deadland"+ ChatColor.DARK_RED+"Plugin		   ");
        Bukkit.getConsoleSender().sendMessage(" - Creador "+ChatColor.YELLOW+"Tridox25");
        Bukkit.getConsoleSender().sendMessage(" - Version "+ChatColor.YELLOW+version);
        Bukkit.getConsoleSender().sendMessage(" - Estado  "+ChatColor.YELLOW+"Correcto");
        Bukkit.getConsoleSender().sendMessage("--------------------------------");

        // Register our command "kit" (set an instance of your command class as executor)
        this.getCommand("item").setExecutor(new Item());

        getServer().getPluginManager().registerEvents(new ShieldCooldown( this), this);
        getServer().getPluginManager().registerEvents(new SouldSand( this), this);
        getServer().getPluginManager().registerEvents(new SkeletonMinion(this), this);
        getServer().getPluginManager().registerEvents(new PigVindicator( this), this);
        getServer().getPluginManager().registerEvents(new EvokerBoss( this), this);
        getServer().getPluginManager().registerEvents(new ExplodingZombie( this), this);
        getServer().getPluginManager().registerEvents(new NightmareZombie( this), this);
        getServer().getPluginManager().registerEvents(new TotemActivation( this), this);
        getServer().getPluginManager().registerEvents(new WitherInfernal( this), this);
        getServer().getPluginManager().registerEvents(new GoldenAppleWither( this), this);
        getServer().getPluginManager().registerEvents(new VexDiamond( this), this);
        getServer().getPluginManager().registerEvents(new BalanceZombie( this), this);
        getServer().getPluginManager().registerEvents(new ExplodingPigmans( this), this);

























        //Futuros Cambios
        //getServer().getPluginManager().registerEvents(new DungeonGeneration(this), this);
        //getServer().getPluginManager().registerEvents(new SkeletonBoss(this), this);


        EmeraldPickaxe items = new EmeraldPickaxe();
        items.customRecipe();

        EmeraldSword emerald = new EmeraldSword();
        emerald.customRecipe();

        commandManager = new CommandManager();

        commandManager.setup();



    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("--------------------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"			Deadland Plugin		   ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+""+ChatColor.BOLD+"			El plugin ha sido desactivado		   ");
        Bukkit.getConsoleSender().sendMessage("--------------------------------");
    }

    public static Main getInstance() {
        return instance;
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }


}