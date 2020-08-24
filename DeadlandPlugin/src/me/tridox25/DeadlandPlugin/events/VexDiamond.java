package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.potion.PotionEffectType.SPEED;

public class VexDiamond implements Listener {

    public VexDiamond(Main main) {

    }

    @EventHandler
    public void SpawnListener(CreatureSpawnEvent e) {

        int random = ThreadLocalRandom.current().nextInt(100);


        if (random < 100)
            if (e.getEntity() instanceof Vex) {
                LivingEntity z = e.getEntity();
                EntityEquipment equipment = e.getEntity().getEquipment();


                //Armor


                ItemStack bw = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta mbw = bw.getItemMeta();

                bw.setItemMeta(mbw);

                //Enchantments



                //Armor Color


                //Equip

                equipment.setItemInMainHand(bw);
                equipment.setItemInOffHand(new ItemStack(Material.SHIELD));



            }
    }


}

