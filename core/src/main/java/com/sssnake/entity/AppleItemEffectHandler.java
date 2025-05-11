package com.sssnake.entity;

import com.sssnake.entity.item.Item;
import com.sssnake.entity.snake.Snake;
import com.sssnake.system.Score;

public class AppleItemEffectHandler implements ItemEffectHandler {

    @Override
    public void handle(Item item, Snake snake) {
        snake.grow();
        item.setSpawnCoordination();
        Score.add(1);
    }
}
