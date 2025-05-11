package com.sssnake.entity.item;

import com.sssnake.entity.AnsiColor;
import com.sssnake.entity.DisplaySymbol;

public class AppleItem extends Item {
    public AppleItem(SpawnStrategy spawnStrategy) {
        super(
                spawnStrategy,
                new DisplaySymbol.Builder()
                        .symbol('A')
                        .backgroundColor(AnsiColor.BG_RED)
                        .textColor(AnsiColor.WHITE)
                        .build()
        );
    }
}
