package com.sssnake.entity.item;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledRandomItemSpawner implements ItemSpawner {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private final ItemManager itemManager;

    public ScheduledRandomItemSpawner(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @Override
    public void startSpawning(int width, int height) {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            Item newItem = ItemFactory.createRandomCoordItem(width, height);
            itemManager.addItem(newItem);
        }, 0, 10, TimeUnit.SECONDS);
    }
}
