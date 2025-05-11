package com.sssnake.system;

import com.sssnake.entity.CollisionHandlerManager;
import com.sssnake.entity.item.ItemManager;
import com.sssnake.entity.snake.Snake;

import static com.sssnake.system.GameConfig.REDISPLAY_DELAY;

public class GameLoopThread extends Thread {

    private final Snake snake;
    private final GameMap gameMap;
    private final Renderer renderer;
    private final CollisionHandlerManager collisionHandlerManager;
    private final ItemManager itemManager;
    private volatile boolean running = true;

    private final GameOverEventListener gameOverEventListener;
    private final GameOverChecker gameOverChecker;

    public GameLoopThread(
            Snake snake,
            GameMap gameMap,
            Renderer renderer,
            CollisionHandlerManager collisionHandlerManager,
            GameOverEventListener gameOverEventListener,
            GameOverChecker gameOverChecker,
            ItemManager itemManager
    ) {
        this.snake = snake;
        this.gameMap = gameMap;
        this.renderer = renderer;
        this.collisionHandlerManager = collisionHandlerManager;
        this.gameOverEventListener = gameOverEventListener;
        this.gameOverChecker = gameOverChecker;
        this.itemManager = itemManager;
    }

    @Override
    public void run() {
        while (running) {
            renderer.clear();
            logic();
            renderer.render();

            try {
                Thread.sleep(REDISPLAY_DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void logic() {
        snake.setDirection(GameInputThread.getNextDirection(snake.getDirection()));
        snake.move();

        if (gameOverChecker.isGameOver()) {
            if (gameOverEventListener != null) {
                gameOverEventListener.onGameOver();
                running = false;
                return;
            }
        }

        collisionHandlerManager.handleCollision(snake, itemManager.getItems());

        gameMap.update(snake, itemManager.getItems());
    }
}
