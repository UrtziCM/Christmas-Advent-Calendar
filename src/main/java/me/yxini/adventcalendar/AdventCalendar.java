package me.yxini.adventcalendar;

import me.yxini.adventcalendar.commands.AdventCalendarCommand;
import me.yxini.adventcalendar.listeners.AdventInventoryListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdventCalendar extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[Advent calendar] Loading plugin...");
        getServer().getPluginManager().registerEvents(new AdventInventoryListener(), this);
        getCommand("advent-calendar").setExecutor(new AdventCalendarCommand());
    }

    public static String christmazize(String text) {
        String coloredText = "";
        for (int i = 0; i < text.length(); i++) {
            char thisChar =text.charAt(i);
            switch (i%3) {
                case 0:
                    coloredText += ChatColor.RED + (thisChar + "");
                    break;
                case 1:
                    coloredText += ChatColor.WHITE + (thisChar + "");
                    break;
                case 2:
                    coloredText += ChatColor.GREEN + (thisChar + "");
                    break;
            }
        }
        return coloredText;
    }
}
