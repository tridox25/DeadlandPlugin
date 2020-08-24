package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static org.bukkit.potion.PotionEffectType.SPEED;

public class NaturalSkeleton implements Listener {


    private Main plugin;

    public NaturalSkeleton (Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void SpawnListener(CreatureSpawnEvent e) {




        if(e.getEntity() instanceof Skeleton) {
            LivingEntity z = e.getEntity();
            EntityEquipment equipment = e.getEntity().getEquipment();



            //Armor
            ItemStack bw = new ItemStack(Material.BOW);
            ItemMeta mbw = bw.getItemMeta();

            bw.setItemMeta(mbw);

            //Enchantments

            bw.addEnchantment(Enchantment.ARROW_DAMAGE, 3);


            //Equip
            equipment.setItemInMainHand(bw);
            equipment.setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));

        }
    }



}

