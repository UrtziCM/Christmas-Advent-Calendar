package me.yxini.adventcalendar.inventories;

import me.yxini.adventcalendar.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.yxini.adventcalendar.AdventCalendar.christmazize;


public class DaySelectorInventory {
    private final Inventory inventory;

    public DaySelectorInventory(Player ply) {
        inventory = Bukkit.createInventory(ply, 54, christmazize("Advent calendar"));
        inventory.setMaxStackSize(31);
        ItemStack emptySpot = new ItemStack(Material.GRAY_STAINED_GLASS_PANE,1);
        ItemMeta im = emptySpot.getItemMeta();
        im.setDisplayName(" ");
        emptySpot.setItemMeta(im);

        for (int i = 0; i < inventory.getSize(); i++) {
            if ((i > 9 && i < 41 && i % 9 != 0 && i % 9 != 8)) {
                inventory.setItem(i, CustomItems.getPresent(i-9));
            } else {
                inventory.setItem(i,emptySpot);
            }
        }
        ItemStack closeItem = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeItemMeta = closeItem.getItemMeta();
        closeItemMeta.setDisplayName(ChatColor.RED + "Close");
        closeItem.setItemMeta(closeItemMeta);
        inventory.setItem(49,closeItem );
    }

    public Inventory getInventory() {
        return inventory;
    }



}
