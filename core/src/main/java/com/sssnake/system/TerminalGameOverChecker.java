package com.sssnake.system;

import com.sssnake.entity.snake.Snake;
import com.sssnake.entity.snake.Tail;

public class TerminalGameOverChecker implements GameOverChecker {

    private final Snake snake;
    private final int mapWidth;
    private final int mapHeight;

    public TerminalGameOverChecker(Snake snake, int mapWidth, int mapHeight) {
        this.snake = snake;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    @Override
    public boolean isGameOver() {
        return checkSnakeOutOfGameMap() || checkSnakeCollideTails();
    }

    public boolean checkSnakeOutOfGameMap() {
        int snakeX = snake.getHead().getCoordination().getX();
        int snakeY = snake.getHead().getCoordination().getY();
        return snakeX < 0 || snakeX >= mapWidth ||
                snakeY < 0 || snakeY >= mapHeight;
    }

    public boolean checkSnakeCollideTails() {
        for (Tail tail : snake.getTails()) {
            if (snake.getHead().getCoordination().equals(tail.getCoordination())) {
                return true;
            }
        }
        return false;
    }
}
