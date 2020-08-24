package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
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

public class NightmareZombie implements Listener {


    private Main plugin;

    public NightmareZombie (Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void SpawnListener(CreatureSpawnEvent e) {

        int random = ThreadLocalRandom.current().nextInt(100);

        if (random < 25) {


            if (e.getEntity() instanceof Zombie) {
                LivingEntity z = e.getEntity();
                EntityEquipment equipment = e.getEntity().getEquipment();

                z.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Nightmare Zombie");
                z.setCustomNameVisible(true);
                z.setMetadata("NightmareZombie", new FixedMetadataValue(plugin, "NightmareZombie"));


                //Armor
                ItemStack sw = new ItemStack(Material.DIAMOND_SWORD);
                ItemStack hlem = new ItemStack(Material.DIAMOND_HELMET);
                ItemStack ches = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemStack bts = new ItemStack(Material.DIAMOND_BOOTS);



                //Equip
                equipment.setItemInMainHand(sw);
                equipment.setHelmet(hlem);
                equipment.setChestplate(ches);
                equipment.setLeggings(leg);
                equipment.setBoots(bts);
                equipment.setItemInOffHand(new ItemStack(Material.SPLASH_POTION));

            }
        }
    }
    @EventHandler
    public void OnDamageEntity (EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Zombie) {
            if (e.getEntity().hasMetadata("NightmareZombie")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 25) {
                    Player player = (Player) e.getDamager();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 3));

                }

            }
        }
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Zombie) {
            if (e.getEntity().hasMetadata("NightmareZombie")) {
                int random = ThreadLocalRandom.current().nextInt();
                if (random < 25) {
                    Player player = (Player) e.getDamager();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 1));
                }
            }
        }
    }


}
