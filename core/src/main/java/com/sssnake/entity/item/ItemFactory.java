package com.sssnake.entity.item;

public class ItemFactory {
    public static Item createRandomCoordItem(int width, int height) {
        return new AppleItem(new RandomSpawnStrategy(width, height));
    }
}
