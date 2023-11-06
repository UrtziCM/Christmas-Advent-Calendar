package me.yxini.adventcalendar;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;


public class CustomItems {
    public static ItemStack getPresent(int quantity) {
        ItemStack present = new ItemStack(Material.BRICK, quantity);

        ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.BRICK);
        meta.setCustomModelData(8789);
        meta.setDisplayName("Present");
        meta.getItemFlags().add(ItemFlag.HIDE_ENCHANTS);
        present.setItemMeta(meta);
        return present;
    }
}
