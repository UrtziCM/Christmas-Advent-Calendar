package me.yxini.adventcalendar.listeners;


import me.yxini.adventcalendar.AdventCalendar;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Calendar;


public class AdventInventoryListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(AdventCalendar.christmazize("Advent calendar"))) {
            event.setCancelled(true);
            if (event.getAction() != InventoryAction.PICKUP_ALL) return;
            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                if (clickedItem.getType() == Material.RED_STAINED_GLASS_PANE)
                    event.getView().getPlayer().closeInventory();
                Calendar cal = Calendar.getInstance();
                if (cal.get(Calendar.MONTH) == Calendar.NOVEMBER && cal.get(Calendar.DAY_OF_MONTH) >= clickedItem.getAmount()) {
                    Bukkit.getWorlds().get(0).playSound(event.getView().getPlayer(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.1F, 1);
                }
            }
        }
    }

}

