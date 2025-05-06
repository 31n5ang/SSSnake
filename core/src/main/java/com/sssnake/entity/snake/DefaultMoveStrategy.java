package com.sssnake.entity.snake;

public class DefaultMoveStrategy implements MoveStrategy {

    private final Snake snake;

    public DefaultMoveStrategy(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void move() {
        // It's important to maintain the order.
        moveTail();
        moveHead();
    }

    public void moveHead() {
        Head head = snake.getHead();
        Direction dir = snake.getDirection();
        head.setX(head.getX() + dir.dx());
        head.setY(head.getY() + dir.dy());
    }

    public void moveTail() {
        int headX = snake.getHead().getX();
        int headY = snake.getHead().getY();

        snake.removeLastTail();
        snake.addFirstTail(headX, headY);
    }
}
