package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static org.bukkit.potion.PotionEffectType.SPEED;

public class NaturalSpawnCustomMobs implements Listener {

    private Main plugin;


    public NaturalSpawnCustomMobs(Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void SpawnListener(CreatureSpawnEvent e) {

        int random = new Random().nextInt(10);



        if(random == 2) {
            if(e.getEntity() instanceof Zombie) {
                LivingEntity z = e.getEntity();
                EntityEquipment equipment = e.getEntity().getEquipment();



                //Armor
                z.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Super Zombie");
                z.setCustomNameVisible(true);
                ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                ItemStack sw = new ItemStack(Material.DIAMOND_SWORD);

                //Enchantments
                chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                sw.addEnchantment(Enchantment.DAMAGE_ALL, 4);

                //Equip
                equipment.setChestplate(chest);
                equipment.setBoots(boots);
                equipment.setItemInMainHand(sw);
            }
        }
    }



}

