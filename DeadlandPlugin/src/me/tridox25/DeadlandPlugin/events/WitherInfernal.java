package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.potion.PotionEffectType.SPEED;

public class WitherInfernal implements Listener {

    public WitherInfernal(Main main) {

    }

    private Main plugin;

    @EventHandler
    public void SpawnListener(CreatureSpawnEvent e) {

        int random = ThreadLocalRandom.current().nextInt(100);


        if (random < 35)
            if (e.getEntity() instanceof WitherSkeleton) {
                LivingEntity z = e.getEntity();
                EntityEquipment equipment = e.getEntity().getEquipment();


                //Armor
                z.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Wither Infernal");
                z.setCustomNameVisible(true);
                z.setMetadata("WitherInfernal", new FixedMetadataValue(plugin, "zombiemortal"));


                ItemStack hel = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta mhel = (LeatherArmorMeta) hel.getItemMeta();

                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta mchest = (LeatherArmorMeta) chest.getItemMeta();

                ItemStack leg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta mleg = (LeatherArmorMeta) leg.getItemMeta();

                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta mbts = (LeatherArmorMeta) boots.getItemMeta();

                ItemStack sw = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta mbw = sw.getItemMeta();

                sw.setItemMeta(mbw);

                //Enchantments
                chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                sw.addEnchantment(Enchantment.DAMAGE_ALL, 5);

                //Armor Color
                mhel.setColor(Color.BLACK);
                hel.setItemMeta(mhel);

                mchest.setColor(Color.BLACK);
                chest.setItemMeta(mchest);

                mleg.setColor(Color.BLACK);
                leg.setItemMeta(mleg);

                mbts.setColor(Color.BLACK);
                boots.setItemMeta(mbts);


                //Equip
                equipment.setHelmet(hel);
                equipment.setChestplate(chest);
                equipment.setLeggings(leg);
                equipment.setBoots(boots);
                equipment.setItemInMainHand(sw);
                equipment.setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));

                new BukkitRunnable() {
                    public void run() {
                        z.remove();
                    }
                }.runTaskLater(Main.getInstance(), 6000);

            }
    }
    @EventHandler
    public void onDeath (EntityDeathEvent e) {
        int ranodm = ThreadLocalRandom.current().nextInt(100);
        if (ranodm < 25) {
            if (e.getEntity() instanceof WitherSkeleton) {
                if (e.getEntity().hasMetadata("WitherInfernal")) {
                    e.getDrops().clear();
                    e.getDrops().add(new ItemStack(Material.TOTEM_OF_UNDYING));
                }
            }
        }
    }

}
