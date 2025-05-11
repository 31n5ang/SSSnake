package com.sssnake.system;

import com.sssnake.entity.Coordination;
import com.sssnake.entity.DisplaySymbol;
import com.sssnake.entity.item.Item;
import com.sssnake.entity.snake.Snake;

import java.util.Arrays;
import java.util.List;

public class GameMap {
    private final static char BLANK = ' ';
    private final int width;
    private final int height;
    private DisplaySymbol[][] grid;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new DisplaySymbol[height][width];
    }

    public DisplaySymbol[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void clearGrid() {
        for (int y = 0; y < height; y++) {
            Arrays.fill(grid[y], new DisplaySymbol.Builder().symbol(BLANK).build());
        }
    }

    public void update(Snake snake, List<Item> items) {
        clearGrid();
        updateSnake(snake);
        updateItems(items);
    }

    private void updateItems(List<Item> items) {
        for (Item item : items) {
            grid[item.getY()][item.getX()] = item.getDisplaySymbol();
        }
    }

    private void updateSnake(Snake snake) {
        grid[snake.getHead().getY()][snake.getHead().getX()] = snake.getHead().getDisplaySymbol();
        for (Coordination coord : snake.getTails()) {
            grid[coord.getY()][coord.getX()] = snake.getFirstTail().getDisplaySymbol();
        }
    }
}
