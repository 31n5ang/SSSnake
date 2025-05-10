package com.sssnake.entity.snake;

import com.sssnake.entity.*;

public class Head extends Coordination implements Displayable {
    public Head(int x, int y) {
        super(x, y);
    }

    @Override
    public DisplaySymbol getDisplaySymbol() {
        return new DisplaySymbol.Builder()
                .symbol('*')
                .textColor(AnsiColor.MAGENTA)
                .backgroundColor(AnsiColor.BG_GREEN)
                .build();
    }
}
