package com.sssnake.entity.snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeDirectionTest {

    private Snake snake;

    @BeforeEach
    void setUp() {
        Head initialHead = new Head(5, 5);
        snake = new Snake(initialHead, Direction.R);
    }

    @Test
    void testInitialDirection() {
        assertEquals(Direction.R, snake.getDirection(), "초기 방향은 오른쪽이어야 함");
    }

    @Test
    void testChangeDirectionToUp() {
        snake.setDirection(Direction.U);
        assertEquals(Direction.U, snake.getDirection());
    }

    @Test
    void testChangeDirectionToDown() {
        snake.setDirection(Direction.D);
        assertEquals(Direction.D, snake.getDirection());
    }

    @Test
    void testOppositeDirectionChangeIsIgnored() {
        snake.setDirection(Direction.L);
        assertEquals(Direction.R, snake.getDirection());
    }
}
