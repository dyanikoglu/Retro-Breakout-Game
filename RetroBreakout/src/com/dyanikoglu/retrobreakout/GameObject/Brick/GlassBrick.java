package com.dyanikoglu.retrobreakout.GameObject.Brick;

public class GlassBrick extends Brick {
    public GlassBrick(int x, int y) {
        super(x, y);
        this.setHeight(24);
        this.setWidth(72);
        this.setIcon(loader.getResource("image/brick_glass.png"));
        this.setType(3);
    }
}
