package com.sssnake.entity.handler;

import com.sssnake.entity.item.Item;
import com.sssnake.entity.snake.Snake;

public class AppleItemEffectHandler implements ItemEffectHandler {
    @Override
    public void handle(Item item, Snake snake) {
        if (item.isCanBeConsumed()) {
            snake.grow();
            item.respawn();
        }
    }
}
