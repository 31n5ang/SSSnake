package com.sssnake.entity.snake;

import com.sssnake.entity.*;

public class Tail extends Coordination implements Displayable {
    public Tail(int x, int y) {
        super(x, y);
    }

    @Override
    public DisplaySymbol getDisplaySymbol() {
        return new DisplaySymbol.Builder()
                .symbol('*')
                .textColor(AnsiColor.WHITE)
                .backgroundColor(AnsiColor.BG_BLUE)
                .build();
    }
}
