package com.sssnake.entity.item;

import com.sssnake.entity.Coordination;
import com.sssnake.entity.DisplaySymbol;
import com.sssnake.entity.Displayable;

public abstract class Item extends Coordination implements Displayable {

    private final SpawnStrategy spawnStrategy;
    protected final DisplaySymbol displaySymbol;

    public Item(SpawnStrategy spawnStrategy, DisplaySymbol displaySymbol) {
        super(0, 0);
        this.spawnStrategy = spawnStrategy;
        this.displaySymbol = displaySymbol;
    }

    @Override
    public DisplaySymbol getDisplaySymbol() {
        return displaySymbol;
    }

    public void setSpawnCoordination() {
        Coordination spawnCoord = spawnStrategy.spawn();
        setX(spawnCoord.getX());
        setY(spawnCoord.getY());
    }
}
