package com.sssnake.entity.item;

import com.sssnake.entity.Coordination;

import java.util.Random;

public class RandomSpawnStrategy implements SpawnStrategy {

    private final int width;
    private final int height;

    public RandomSpawnStrategy(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Coordination spawn() {
        Random random = new Random();

        int x = random.nextInt(width);
        int y = random.nextInt(height);

        return new Coordination(x, y);
    }
}
