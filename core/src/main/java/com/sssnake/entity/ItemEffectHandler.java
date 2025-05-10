package com.sssnake.entity;

import com.sssnake.entity.item.Item;
import com.sssnake.entity.snake.Snake;

public interface ItemEffectHandler {
    void handle(Item item, Snake snake);
}
