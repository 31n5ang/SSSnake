package com.sssnake.entity.snake;

import com.sssnake.entity.Coordination;

import java.util.LinkedList;

public class Snake {
    private final Head head;
    private final MoveStrategy moveStrategy;
    private LinkedList<Tail> tails = new LinkedList<>();
    private Direction direction;

    public Snake(Head head, Direction direction) {
        this.head = head;
        this.direction = direction;
        this.moveStrategy = new DefaultMoveStrategy(this);
    }

    public Head getHead() {
        return head;
    }

    public LinkedList<Tail> getTails() {
        return tails;
    }

    public void setTails(LinkedList<Tail> tails) {
        this.tails = tails;
    }

    public Tail getFirstTail() {
        if (!tails.isEmpty()) {
            return tails.getFirst();
        } else {
            throw new IllegalStateException("The tail is empty!");
        }
    }

    public Tail getLastTail() {
        if (!tails.isEmpty()) {
            return tails.getLast();
        } else {
            throw new IllegalStateException("The tail is empty!");
        }
    }

    public void removeLastTail() {
        if (!tails.isEmpty()) {
            tails.removeLast();
        }
    }

    public void addFirstTail(int x, int y) {
        Tail newTail = new Tail(x, y);
        tails.addFirst(newTail);
    }

    public void addLastTail(int x, int y) {
        Tail newTail = new Tail(x, y);
        tails.addLast(newTail);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection) {
        if (!this.direction.isOpposite(newDirection)) {
            this.direction = newDirection;
        }
    }

    public void move() {
        moveStrategy.move();
    }

    public void grow() {
        if (tails.isEmpty()) {
            int x = head.getX() - direction.dx();
            int y = head.getY() - direction.dy();
            addLastTail(x, y);
        } else {
            Coordination last = getLastTail().getCoordination();
            Coordination beforeLast = null;
            if (tails.size() > 1) {
                beforeLast = tails.get(tails.size() - 2).getCoordination();
            } else {
                beforeLast = head.getCoordination();
            }
            int dx = beforeLast.getX() - last.getX();
            int dy = beforeLast.getY() - last.getY();
            int nx = last.getX() + dx;
            int ny = last.getY() + dy;
            addLastTail(nx, ny);
        }
    }
}
