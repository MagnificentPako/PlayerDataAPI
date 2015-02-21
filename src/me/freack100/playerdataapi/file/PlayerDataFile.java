/*
 *
 *  * Copyright © 2015 Paul Waslowski <freack1208@gmail.com>
 *  * This work is free. You can redistribute it and/or modify it under the
 *  * terms of the Do What The Fuck You Want To Public License, Version 2,
 *  * as published by Sam Hocevar. See the LICENSE file for more details.
 *
 */

package me.freack100.playerdataapi.file;

import me.freack100.playerdataapi.PlayerData;
import me.freack100.playerdataapi.PlayerDataAPI;

import java.io.File;
import java.util.*;

public class PlayerDataFile {

    private TextFile file;
    private UUID uuid;
    private PlayerDataAPI api;

    public PlayerDataFile(UUID uuid, PlayerDataAPI api) {
        this.uuid = uuid;
        this.api = api;
        if (!(new File(api.getDataFolder() + File.separator + "data").exists()))
            new File(api.getDataFolder() + File.separator + "data").mkdirs();
        this.file = new TextFile(new File(api.getDataFolder() + File.separator + "data" + File.separator + uuid.toString()));
    }

    public PlayerData readData() {
        PlayerData data = new PlayerData();

        String contentRaw = file.readContent();
        String[] lines = contentRaw.split("\n");
        for (String line : lines) {
            line = line.replace("\"","");
            String[] lineContent = line.split(":");
            data.addData(lineContent[0], lineContent[1]);
        }
        return data;
    }

    public void saveData() {
        HashMap<String, String> data = api.getData(uuid).getAllData();
        file.clear();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            file.appendContent(entry.getKey() + ":" + entry.getValue() + "\n");
        }
    }

}
