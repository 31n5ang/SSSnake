package com.sssnake;

import com.sssnake.entity.AppleItemEffectHandler;
import com.sssnake.entity.CollisionHandlerManager;
import com.sssnake.entity.item.AppleItem;
import com.sssnake.entity.item.ItemManager;
import com.sssnake.entity.item.ItemSpawner;
import com.sssnake.entity.snake.Snake;
import com.sssnake.system.*;
import org.jline.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        startGame();
    }

    private static void startGame() throws IOException {
        Terminal terminal = GameFactory.createTerminal();
        Snake snake = GameFactory.createSnake();
        GameMap map = GameFactory.createMap();
        Renderer renderer = GameFactory.createRenderer(map, terminal);

        ItemManager itemManager = GameFactory.createItemManager();
        ItemSpawner itemSpawner = GameFactory.createItemSpawner(itemManager);
        itemSpawner.startSpawning(map.getWidth(), map.getHeight());

        CollisionHandlerManager collisionHandlerManager = GameFactory.createCollisionHandlerManager();
        GameOverEventListener gameOverEventListener = GameFactory.createGameOverEventListener(terminal);
        GameOverChecker gameOverChecker = GameFactory.createGameOverChecker(snake);

        collisionHandlerManager.register(AppleItem.class, new AppleItemEffectHandler());

        GameInputThread gameInputThread = GameFactory.createInput(terminal);
        GameLoopThread gameLoopThread = GameFactory.createGameLoop(
                snake,
                map,
                renderer,
                collisionHandlerManager,
                gameOverEventListener,
                gameOverChecker,
                itemManager
        );

        gameLoopThread.start();
        gameInputThread.start();
    }
}
