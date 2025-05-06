package com.sssnake.entity;

public class Coordination {
    private int x, y;

    public Coordination() {
        this.x = 0;
        this.y = 0;
    }

    public Coordination(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
