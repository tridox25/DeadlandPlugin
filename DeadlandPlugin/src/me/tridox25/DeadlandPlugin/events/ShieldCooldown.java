package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import javax.xml.stream.Location;
import java.util.concurrent.ThreadLocalRandom;

public class ShieldCooldown implements Listener {


    private Main plugin;

    public ShieldCooldown(Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void shieldUseEvent(EntityDamageByEntityEvent e) {
        Player player = (Player) e.getEntity();

        int random = ThreadLocalRandom.current().nextInt(100);

        if (random < 25) {
            if (player.isBlocking()) {
                player.setCooldown(Material.SHIELD, 100);
                player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 10, 10);
            }
        }
    }




}
