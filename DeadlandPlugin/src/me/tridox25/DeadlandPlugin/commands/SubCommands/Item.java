package me.tridox25.DeadlandPlugin.commands.SubCommands;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class Item extends SubCommand {
    private Main plugin = Main.getInstance();


    @Override
    public void onCommand(Player player, String[] args) {


        ItemStack casco = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack pechera = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

        ItemMeta cascometa = casco.getItemMeta();
        cascometa.setUnbreakable(true);
        cascometa.setCustomModelData(2);
        cascometa.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Casco de Netherite");
        casco.setItemMeta(cascometa);


        ItemMeta pecherameta = pechera.getItemMeta();
        pecherameta.setUnbreakable(true);
        pecherameta.setCustomModelData(2);
        pecherameta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Pechera de Netherite");
        pechera.setItemMeta(pecherameta);

        ItemMeta leggingsmeta = leggings.getItemMeta();
        leggingsmeta.setUnbreakable(true);
        leggingsmeta.setCustomModelData(2);
        leggingsmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Pechera de Netherite");
        leggings.setItemMeta(leggingsmeta);

        ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.setUnbreakable(true);
        bootsmeta.setCustomModelData(2);
        bootsmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Pechera de Netherite");
        boots.setItemMeta(bootsmeta);

        player.getInventory().addItem(casco);
        player.getInventory().addItem(pechera);
        player.getInventory().addItem(leggings);
        player.getInventory().addItem(boots);



    }

    @Override
    public String name() {
        return "item";
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