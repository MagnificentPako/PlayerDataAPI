/*
 *
 *  * Copyright © 2015 Paul Waslowski <freack1208@gmail.com>
 *  * This work is free. You can redistribute it and/or modify it under the
 *  * terms of the Do What The Fuck You Want To Public License, Version 2,
 *  * as published by Sam Hocevar. See the LICENSE file for more details.
 *
 */

package me.freack100.playerdataapi.collector.collectors;

import me.freack100.playerdataapi.PlayerDataAPI;
import me.freack100.playerdataapi.collector.Collector;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.UUID;

public class BlocksPlacedCollector extends Collector {

    private PlayerDataAPI api;

    public BlocksPlacedCollector(PlayerDataAPI api) {
        this.api = api;
    }

    @EventHandler
    public void on(BlockPlaceEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        int data = api.getData(uuid).get("blocksPlaced") != null ? Integer.parseInt(api.getData(uuid).get("blocksPlaced")) : 0;
        api.getData(uuid).addData("blocksPlaced", String.valueOf(data + 1));
    }
}
