package me.tridox25.DeadlandPlugin.commands.SubCommands;

import me.tridox25.DeadlandPlugin.Main;
import net.minecraft.server.v1_15_R1.EntitySkeleton;
import net.minecraft.server.v1_15_R1.WorldServer;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Wither extends SubCommand {
    private Main plugin = Main.getInstance();


    @Override
    public void onCommand(Player player, String[] args) {

        Skeleton witherskeleton = player.getWorld().spawn(player.getLocation(), WitherSkeleton.class);
        EntityEquipment equipment = witherskeleton.getEquipment();



        witherskeleton.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Esqueleto de Clase");
        witherskeleton.setCustomNameVisible(true);

        //Tools & Armor
        ItemStack arco = new ItemStack(Material.BOW);
        ItemMeta marco = arco.getItemMeta();

        ItemStack hel = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta ameta = (LeatherArmorMeta) hel.getItemMeta();

        ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta mches = (LeatherArmorMeta) ches.getItemMeta();

        ItemStack leg = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta mleg = (LeatherArmorMeta) leg.getItemMeta();

        ItemStack bts = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta mbts = (LeatherArmorMeta) bts.getItemMeta();

        ItemStack ttm = new ItemStack(Material.TOTEM_OF_UNDYING);

        //Enchantments
        arco.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        hel.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

        ches.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

        leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

        bts.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        bts.addEnchantment(Enchantment.PROTECTION_FALL, 3);

        //Equipment
        witherskeleton.getEquipment().setHelmet(hel);


        witherskeleton.getEquipment().setChestplate(ches);


        witherskeleton.getEquipment().setLeggings(leg);


        witherskeleton.getEquipment().setBoots(bts);

        witherskeleton.getEquipment().setItemInMainHand(arco);

        witherskeleton.getEquipment().setItemInOffHand(ttm);


        //Item Meta
        ameta.setColor(Color.RED);
        hel.setItemMeta(ameta);

        mches.setColor(Color.RED);
        ches.setItemMeta(mches);

        mleg.setColor(Color.RED);
        leg.setItemMeta(mleg);

        mbts.setColor(Color.RED);
        bts.setItemMeta(mbts);


    }



    @Override
    public String name() {
        return "wither";
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String version() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}