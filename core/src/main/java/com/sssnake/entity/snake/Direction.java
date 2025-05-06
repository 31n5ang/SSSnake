package com.sssnake.entity.snake;

public enum Direction {
    U(0, -1),
    D(0, 1),
    R(1, 0),
    L(-1, 0);

    private final int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }

    public boolean isOpposite(Direction other) {
        return (this == U && other == D)
                || (this == D && other == U)
                || (this == L && other == R)
                || (this == R && other == L);
    }
}
