/*
 *
 *  * Copyright © 2015 Paul Waslowski <freack1208@gmail.com>
 *  * This work is free. You can redistribute it and/or modify it under the
 *  * terms of the Do What The Fuck You Want To Public License, Version 2,
 *  * as published by Sam Hocevar. See the LICENSE file for more details.
 *
 */

package me.freack100.playerdataapi.commands;

import me.freack100.playerdataapi.PlayerDataAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class VisualizeDataCommand implements CommandExecutor {

    private PlayerDataAPI api;

    public VisualizeDataCommand(PlayerDataAPI api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {

        if (!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;

        //Get data of the player using the command
        if (args.length == 0) {
            Inventory inv = api.inventoryBuilder.buildInventory(player.getUniqueId(), 0);
            player.openInventory(inv);
            return true;
        }
        //Get data of specified player/the console
        else {
            //Get Information about the console
            if(args[0].equalsIgnoreCase("console")){
                Inventory inv = api.inventoryBuilder.buildInventory(api.getConsoleUUID(),0);
                player.openInventory(inv);
                return true;
            }
            //Information about player
            else{
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    Inventory inv = api.inventoryBuilder.buildInventory(target.getUniqueId(),0);
                    player.openInventory(inv);
                    return true;
                }else{
                    player.sendMessage("Player not found.");
                    return true;
                }
            }
        }
    }
}
