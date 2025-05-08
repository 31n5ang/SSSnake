package com.sssnake.entity.item;

public class Apple extends Item {
    public Apple(SpawnStrategy spawnStrategy) {
        super(spawnStrategy);
        this.setDisplayChar('A');
    }
}
