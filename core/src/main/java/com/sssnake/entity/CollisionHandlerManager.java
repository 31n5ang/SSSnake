package com.sssnake.entity;

import com.sssnake.entity.item.Item;
import com.sssnake.entity.snake.Snake;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionHandlerManager {
    private final Map<Class<? extends Item>, ItemEffectHandler> handlers = new HashMap<>();

    public void register(Class<? extends Item> itemClass, ItemEffectHandler handler) {
        handlers.put(itemClass, handler);
    }

    public void handleCollision(Snake snake, List<Item> items) {
        for (Item item : items) {
            if (isColliding(snake, item)) {
                ItemEffectHandler handler = handlers.get(item.getClass());
                if (handler != null) {
                    handler.handle(item, snake);
                }
            }
        }
    }

    private boolean isColliding(Snake snake, Item item) {
        return snake.getHead().getX() == item.getX() &&
                snake.getHead().getY() == item.getY();
    }
}
