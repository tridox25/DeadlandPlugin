package me.tridox25.DeadlandPlugin.customitems;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class EmeraldSword implements Listener {

    public void customRecipe(){
        ItemStack emeraldSword = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta meta = emeraldSword.getItemMeta();

        Plugin plugin = Main.getPlugin(Main.class);



        meta.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"Espada De Esmeralda");
        meta.setCustomModelData(123456);
        emeraldSword.setItemMeta(meta);



        ShapedRecipe r = new ShapedRecipe(emeraldSword);

        r.shape("DRD", "STS", "DBD");
        r.setIngredient('D', Material.DIAMOND);
        r.setIngredient('R', Material.REDSTONE_BLOCK);
        r.setIngredient('S', Material.NETHER_STAR);
        r.setIngredient('T', Material.DIAMOND_SWORD);
        r.setIngredient('B', Material.BLAZE_ROD);

        plugin.getServer().addRecipe(r);
    }

}