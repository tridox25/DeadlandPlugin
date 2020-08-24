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

public class WitherSkeletonMinion implements Listener {

    public WitherSkeletonMinion(Main main) {

    }

    @EventHandler
    public void SpawnListener(CreatureSpawnEvent e) {

        int random = ThreadLocalRandom.current().nextInt(100);


        if (random < 35)
            if (e.getEntity() instanceof WitherSkeleton) {
                LivingEntity z = e.getEntity();
                EntityEquipment equipment = e.getEntity().getEquipment();


                //Armor
                z.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Esqueleto Wither Peruano");
                z.setCustomNameVisible(true);

                ItemStack hel = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta mhel = (LeatherArmorMeta) hel.getItemMeta();

                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta mchest = (LeatherArmorMeta) chest.getItemMeta();

                ItemStack leg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta mleg = (LeatherArmorMeta) leg.getItemMeta();

                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta mbts = (LeatherArmorMeta) boots.getItemMeta();

                ItemStack bw = new ItemStack(Material.STONE_SWORD);
                ItemMeta mbw = bw.getItemMeta();

                bw.setItemMeta(mbw);

                //Enchantments
                chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                bw.addEnchantment(Enchantment.DAMAGE_ALL, 2);

                //Armor Color
                mhel.setColor(Color.RED);
                hel.setItemMeta(mhel);

                mchest.setColor(Color.RED);
                chest.setItemMeta(mchest);

                mleg.setColor(Color.RED);
                leg.setItemMeta(mleg);

                mbts.setColor(Color.RED);
                boots.setItemMeta(mbts);


                //Equip
                equipment.setHelmet(hel);
                equipment.setChestplate(chest);
                equipment.setLeggings(leg);
                equipment.setBoots(boots);
                equipment.setItemInMainHand(bw);
                equipment.setItemInOffHand(new ItemStack(Material.SHIELD));

                new BukkitRunnable() {
                    public void run() {
                        z.remove();
                    }
                }.runTaskLater(Main.getInstance(), 6000);

            }
    }


}

