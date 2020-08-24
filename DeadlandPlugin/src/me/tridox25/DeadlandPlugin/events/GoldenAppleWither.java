package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.ThreadLocalRandom;

public class GoldenAppleWither implements Listener {

    private Main plugin;


    public GoldenAppleWither(Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void ConsumeEvent (PlayerItemConsumeEvent e) {

        int random = ThreadLocalRandom.current().nextInt(100);

        if (random < 25) {
            if (e.getItem().getType().equals(Material.GOLDEN_APPLE)) {
                Player player = e.getPlayer();
                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 2));
            }
        }
    }

}
