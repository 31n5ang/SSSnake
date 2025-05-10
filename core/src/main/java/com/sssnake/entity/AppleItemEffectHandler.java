package com.sssnake.entity;

import com.sssnake.entity.item.Item;
import com.sssnake.entity.snake.Snake;
import com.sssnake.system.Score;

public class AppleItemEffectHandler implements ItemEffectHandler {
    @Override
    public void handle(Item item, Snake snake) {
        if (item.isCanBeConsumed()) {
            snake.grow();
            item.respawn();
            Score.add(1);
        }
    }
}
