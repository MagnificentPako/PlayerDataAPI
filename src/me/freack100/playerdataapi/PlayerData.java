/*
 *
 *  * Copyright © 2015 Paul Waslowski <freack1208@gmail.com>
 *  * This work is free. You can redistribute it and/or modify it under the
 *  * terms of the Do What The Fuck You Want To Public License, Version 2,
 *  * as published by Sam Hocevar. See the LICENSE file for more details.
 *
 */

package me.freack100.playerdataapi;

import java.util.HashMap;

public class PlayerData {

    private HashMap<String, String> data;

    public PlayerData() {
        this.data = new HashMap();
    }

    public String get(String key) {
        if (data.containsKey(key)) return data.get(key);
        return null;
    }

    public void addData(String key, String value) {
        if (data.containsKey(key)) {
            data.remove(key);
            data.put(key, value);
        } else {
            data.put(key, value);
        }
    }

    public HashMap<String, String> getAllData() {
        return data;
    }

}
