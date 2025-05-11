package com.sssnake.entity.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemManager {

    private final List<Item> items = Collections.synchronizedList(new ArrayList<>());

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
