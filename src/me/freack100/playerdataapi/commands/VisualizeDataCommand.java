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
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class VisualizeDataCommand implements CommandExecutor {

    private PlayerDataAPI api;

    public VisualizeDataCommand(PlayerDataAPI api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {

        if(!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;

        //Get data of the player using the command
        if(args.length == 0){
            Inventory inv = api.inventoryBuilder.buildInventory(player.getUniqueId(),0);
            player.openInventory(inv);
        }
        //Get data of specified player/the console
        else{
            //TODO: Implement this
        }

        return false;
    }
}
