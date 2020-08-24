package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.xml.stream.Location;

public class SouldSand implements Listener {

    private Main plugin;

    public SouldSand(Main main) {
        this.plugin = main;
    }



    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if(block.getType() == Material.SOUL_SAND) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 240, 2));
            player.sendMessage("VAS LENOT XD");
        }
    }

}
