package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;

public class TotemActivation implements Listener {

    private Main plugin;


    public TotemActivation(Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void totemUse(EntityResurrectEvent e) {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            if (e.getEntity() == player) {
                Blaze blaze = player.getLocation().getWorld().spawn(player.getLocation().add(0.5, 0, 0.5), Blaze.class);
                blaze.setMaxHealth(100d);
                blaze.setHealth(100d);
            }
        }
    }
}
