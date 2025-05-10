package com.sssnake.entity;

import java.util.Objects;

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

    public Coordination getCoordination() {
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordination that = (Coordination) o;
        return getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
