package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.potion.PotionEffectType.SPEED;

public class ExplodingPigmans implements Listener {


    private Main plugin;

    public ExplodingPigmans (Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void SpawnListener(CreatureSpawnEvent e) {
        int random = ThreadLocalRandom.current().nextInt(100);
        if (random < 25) {


            if (e.getEntity() instanceof PigZombie) {
                LivingEntity z = e.getEntity();
                EntityEquipment equipment = e.getEntity().getEquipment();

                z.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Pigman Asesino");
                z.setCustomNameVisible(true);
                z.setMetadata("ZombieExplosivo", new FixedMetadataValue(plugin, "zombieexplosivo"));
                z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 2));


                //Armor
                ItemStack tnt = new ItemStack(Material.TNT);
                ItemStack hlem = new ItemStack(Material.TNT);


                //Equip
                equipment.setItemInMainHand(tnt);
                equipment.setHelmet(tnt);


            }
        }
    }
    @EventHandler
    public void OnDamageEntity (EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof PigZombie) {
            if (e.getEntity().hasMetadata("ZombieExplosivo")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 100) {
                    Player player = (Player) e.getDamager();
                    player.getLocation().getWorld().createExplosion(player.getLocation(), 5, false);
                    player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_DEATH, 20, 20);
                }

            }
        }
            if (e.getDamager() instanceof Arrow) {
                final Arrow arrow = (Arrow) e.getDamager();

                if (arrow.getShooter() instanceof Player && e.getDamager() instanceof PigZombie) {
                    if (e.getEntity().hasMetadata("ZombieExplosivo")) {
                        Player player =(Player) arrow.getShooter();
                        e.setCancelled(true);
                        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "No puedes atacarme con flechas");
                    }
                }
            }
        }



}
