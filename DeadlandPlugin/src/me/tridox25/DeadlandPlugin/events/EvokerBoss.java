package me.tridox25.DeadlandPlugin.events;

import me.tridox25.DeadlandPlugin.Main;
import net.minecraft.server.v1_15_R1.AttributeInstance;
import net.minecraft.server.v1_15_R1.BlockCactus;
import net.minecraft.server.v1_15_R1.Items;
import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.w3c.dom.Attr;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.jar.Attributes;

public class EvokerBoss implements Listener {

    private int taskID = -1;
    private BossBar bar;

    private Main plugin;

    public EvokerBoss(Main main) {
        this.plugin = main;
    }

    public void addPlayer(Player pl) {
        bar.addPlayer(pl);
    }

    public BossBar getBar() {
        return bar;
    }


    @EventHandler
    public void onBreakBlockEvent(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.BEDROCK) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            Vindicator evoker = e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0.5, 0, 0.5), Vindicator.class);




            //Equipamiento
            EntityEquipment equipment = evoker.getEquipment();

            //Tools & Armor
            ItemStack sw = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta msw = sw.getItemMeta();





            //Enchantments
            msw.addEnchant(Enchantment.DAMAGE_ALL, 4, false);




            //Colors




            //SetEquipment to zombie
            evoker.getEquipment().setItemInMainHand(sw);
            evoker.getEquipment().setItemInMainHandDropChance(0);

            evoker.getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));






            //Zombie

            evoker.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 3));
            evoker.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 4));
            evoker.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Strange Evoker");
            evoker.setCustomNameVisible(true);
            evoker.setMetadata("EvokerBoss", new FixedMetadataValue(plugin, "zombiemortal"));
            evoker.setMaxHealth(500d);
            evoker.setHealth(500d);









            }
        }
        @EventHandler
        public void onDamage(EntityDamageByEntityEvent e) {

                    if (e.getDamager() instanceof Player && e.getEntity() instanceof Evoker) {
                        if (e.getEntity().hasMetadata("EvokerBoss")) {
                            int random = ThreadLocalRandom.current().nextInt(100);
                            if (random < 50) {
                                Player player = (Player) e.getDamager();
                                player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 5));
                            }
                        }
                    }
                    if (e.getDamager() instanceof Player && e.getEntity() instanceof Evoker) {
                        if (e.getEntity().hasMetadata("EvokerBoss")) {
                            int random = ThreadLocalRandom.current().nextInt(100);
                            if (random < 50) {
                                Player player = (Player) e.getDamager();
                                player.setVelocity(new Vector(10, 25, 10));
                                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 10, 10);
                            }

                        }
                    }
            if (e.getDamager() instanceof Arrow) {
                final Arrow arrow = (Arrow) e.getDamager();
                if (arrow.getShooter() instanceof Player && e.getEntity() instanceof Evoker) {
                    if (e.getEntity().hasMetadata("EvokerBoss")) {
                        int random = ThreadLocalRandom.current().nextInt(100);
                        if (random < 100) {
                            Player player = (Player) arrow.getShooter();
                            e.setCancelled(true);
                            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "No puedes atacarme con flechas");
                        }
                    }
                }
            }

                }


}






