package me.yxini.adventcalendar.commands;

import me.yxini.adventcalendar.inventories.DaySelectorInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdventCalendarCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        assert commandSender instanceof Player : "A non player entity used the command";

        Player ply = (Player) commandSender;
        DaySelectorInventory adventWeekInventory = new DaySelectorInventory(ply);

        ply.openInventory(adventWeekInventory.getInventory());

        return true;
    }
}
