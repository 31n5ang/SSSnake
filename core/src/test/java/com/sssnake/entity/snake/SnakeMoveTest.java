package com.sssnake.entity.snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeMoveTest {

    private Snake snake;

    @BeforeEach
    void setUp() {
        Head initialHead = new Head(5, 5);
        LinkedList<Tail> tails = new LinkedList<>();
        tails.add(new Tail(4, 5));
        tails.add(new Tail(3, 5));

        MoveStrategy strategy = new DefaultMoveStrategy(snake);
        snake = new Snake(initialHead, Direction.R);
        snake.setTails(tails);
    }

    @Test
    void testMove() {
        snake.move();

        assertEquals(6, snake.getHead().getX());
        assertEquals(5, snake.getHead().getY());

        assertEquals(5, snake.getFirstTail().getX());
        assertEquals(5, snake.getFirstTail().getY());

        assertEquals(4, snake.getLastTail().getX());
        assertEquals(5, snake.getLastTail().getY());
    }
}
