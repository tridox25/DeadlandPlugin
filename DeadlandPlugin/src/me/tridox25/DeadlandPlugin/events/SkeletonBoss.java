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

public class SkeletonBoss implements Listener {

    private int taskID = -1;
    private BossBar bar;

    private Main plugin;

    public SkeletonBoss(Main main) {
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
            Zombie zombie = e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0.5, 0, 0.5), Zombie.class);




            //Equipamiento
            EntityEquipment equipment = zombie.getEquipment();

            //Tools & Armor
            ItemStack sw = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta msw = sw.getItemMeta();

            ItemStack hel = new ItemStack(Material.BLUE_STAINED_GLASS);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta mches = (LeatherArmorMeta) ches.getItemMeta();

            ItemStack leg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta mleg = (LeatherArmorMeta) leg.getItemMeta();

            ItemStack bts = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta mbts = (LeatherArmorMeta) bts.getItemMeta();

            //Enchantments
            msw.addEnchant(Enchantment.DAMAGE_ALL, 4, false);

            mches.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);

            mleg.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);

            mbts.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);

            //Colors
            mches.setColor(Color.BLUE);
            ches.setItemMeta(mches);

            mleg.setColor(Color.BLUE);
            leg.setItemMeta(mleg);

            mbts.setColor(Color.BLUE);
            bts.setItemMeta(mbts);

            //SetEquipment to zombie
            zombie.getEquipment().setItemInMainHand(sw);
            zombie.getEquipment().setItemInMainHandDropChance(0);

            zombie.getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));

            zombie.getEquipment().setHelmet(hel);
            zombie.getEquipment().setHelmetDropChance(0);

            zombie.getEquipment().setChestplate(ches);
            zombie.getEquipment().setChestplateDropChance(0);

            zombie.getEquipment().setLeggings(leg);
            zombie.getEquipment().setLeggingsDropChance(0);

            zombie.getEquipment().setBoots(bts);
            zombie.getEquipment().setBootsDropChance(0);


            //Zombie

            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 3));
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 4));
            zombie.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Zombie Mortal");
            zombie.setCustomNameVisible(true);
            zombie.setMetadata("ZombieMortal", new FixedMetadataValue(plugin, "zombiemortal"));
            zombie.setHealth(100);




        }


    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Zombie && e.getDamager() instanceof Player) {
            if (e.getEntity().hasMetadata("ZombieMortal")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 85) {
                    e.setCancelled(true);
                    Player player = (Player) e.getDamager();
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 10);
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "TU ATAQUE HA SIDO BLOQUEADO");
                }
            }

        }
        if (e.getEntity() instanceof Zombie && e.getDamager() instanceof Player) {
            if (e.getEntity().hasMetadata("ZombieMortal")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 1) {
                    Player player = (Player) e.getDamager();
                    Location loc = player.getLocation();
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 10, 10);
                    player.getWorld().createExplosion(loc, 20, true);
                    player.sendMessage(ChatColor.BOLD  + "" + ChatColor.GOLD + "SOS un desgraciado.");
                }
            }
        }



        if (e.getDamager() instanceof Player && e.getEntity() instanceof Zombie) {
            if (e.getEntity().hasMetadata("ZombieMortal")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 25) {
                    Player player = (Player) e.getDamager();
                    player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 10, 10);
                    player.getWorld().spawnParticle(Particle.DAMAGE_INDICATOR, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 10, 0, 0, 0);
                    player.damage(10);
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "¡Estas en una nube VENENOSA!");
                }
            }
        }
        if (e.getDamager() instanceof Zombie && e.getEntity() instanceof Player) {
            if (e.getDamager().hasMetadata("ZombieMortal")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 25) {
                    Player player = (Player) e.getEntity();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 14));
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 10, 10);
                    player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Has sido lanzado al CIELO");
                }
            }
        }
        if (e.getDamager() instanceof Arrow) {
            final Arrow arrow = (Arrow) e.getDamager();
            if (arrow.getShooter() instanceof Player && e.getEntity() instanceof Zombie) {
                if (e.getEntity().hasMetadata("ZombieMortal")) {
                    Player player = (Player) arrow.getShooter();
                    int random = ThreadLocalRandom.current().nextInt(100);
                    if (random < 100) {
                        e.setCancelled(true);
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 10);
                        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "TU ATAQUE HA SIDO BLOQUEADO");
                    }
                }
            }
            if (e.getDamager() instanceof Arrow) {
                if (arrow.getShooter() instanceof Player && e.getEntity() instanceof Zombie) {
                    if (e.getEntity().hasMetadata("ZombieMortal")) {
                        Player player = (Player) arrow.getShooter();

                        int random = ThreadLocalRandom.current().nextInt(100);
                        if (random < 80) {
                            player.damage(10);
                        }
                    }
                }
                if (e.getDamager() instanceof Arrow) {
                    if (arrow.getShooter() instanceof Player && e.getEntity() instanceof Zombie) {
                        if (e.getEntity().hasMetadata("ZombieMortal")) {
                            Player player = (Player) arrow.getShooter();
                            int random = ThreadLocalRandom.current().nextInt(100);
                            if (random < 25) {
                                player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 10, 10);
                                player.getWorld().spawnParticle(Particle.DAMAGE_INDICATOR, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 10, 0, 0, 0);
                                player.damage(10);
                                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "¡Estas en una nube VENENOSA!");
                            }
                        }
                    }
                    if (e.getDamager() instanceof Arrow) {
                        if (arrow.getShooter() instanceof Player && e.getEntity() instanceof Zombie) {
                            if (e.getEntity().hasMetadata("ZombieMortal")) {
                                Player player = (Player) arrow.getShooter();
                                int random = ThreadLocalRandom.current().nextInt(100);
                                if (random < 25) {
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 14));
                                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 10, 10);
                                    player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Has sido lanzado al CIELO");
                                }
                            }
                        }
                    }
                    }


            }
        }
    }
}