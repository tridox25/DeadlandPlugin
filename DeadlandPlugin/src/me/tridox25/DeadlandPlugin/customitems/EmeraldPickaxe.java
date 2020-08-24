package me.tridox25.DeadlandPlugin.customitems;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class EmeraldPickaxe implements Listener {

    public void customRecipe(){
        ItemStack emeraldPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

        ItemMeta meta = emeraldPickaxe.getItemMeta();

        Plugin plugin = Main.getPlugin(Main.class);

        emeraldPickaxe.addEnchantment(Enchantment.DIG_SPEED,5);



        meta.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"Pico De Esmeralda");
        meta.setCustomModelData(12345);
        meta.setUnbreakable(true);
        emeraldPickaxe.setItemMeta(meta);



        ShapedRecipe r = new ShapedRecipe(emeraldPickaxe);

        r.shape("EEE", "TDH", "TBH");
        r.setIngredient('E', Material.EMERALD_BLOCK);
        r.setIngredient('T', Material.TOTEM_OF_UNDYING);
        r.setIngredient('D', Material.DIAMOND_PICKAXE);
        r.setIngredient('H', Material.HONEYCOMB_BLOCK);
        r.setIngredient('B', Material.BLAZE_ROD);

        plugin.getServer().addRecipe(r);
    }

}