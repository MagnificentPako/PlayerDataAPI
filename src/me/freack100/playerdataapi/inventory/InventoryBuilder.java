/*
 *
 *  * Copyright © 2015 Paul Waslowski <freack1208@gmail.com>
 *  * This work is free. You can redistribute it and/or modify it under the
 *  * terms of the Do What The Fuck You Want To Public License, Version 2,
 *  * as published by Sam Hocevar. See the LICENSE file for more details.
 *
 */

package me.freack100.playerdataapi.inventory;

import me.freack100.playerdataapi.PlayerDataAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class InventoryBuilder {

    //TODO: Add functionality to this.

    private PlayerDataAPI api;

    private ItemStack getItemForData(String key,String data){
        ItemStack item = new ItemStack(Material.APPLE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(key);
        meta.setLore(Arrays.asList(data));
        item.setItemMeta(meta);
        return item;
    }

    public InventoryBuilder(PlayerDataAPI api) {
        this.api = api;
    }

    public Inventory buildInventory(UUID uuid, int page){
        Inventory inv = Bukkit.createInventory(null,6*9,"Data");
        int dataPerPage = (5*9);

        int currentPos = 0;

        for(Map.Entry<String,String> entry : api.getData(uuid).getAllData().entrySet()){
            inv.setItem(currentPos,getItemForData(entry.getKey(),entry.getValue()));
            currentPos++;
            if(currentPos>=dataPerPage) break;
        }
        return inv;
    }

}
