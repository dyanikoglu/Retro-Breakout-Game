package com.dyanikoglu.retrobreakout.GameObject;

import com.dyanikoglu.retrobreakout.BrickLoader;
import com.dyanikoglu.retrobreakout.GameObject.GameObject;

public class Ball extends GameObject {
    public Ball(int x,int y) {
        this.setIcon(loader.getResource("image/ball.png"));
        this.setX(x);
        this.setY(y);
        this.setWidth(16);
        this.setHeight(16);
    }

    public void movement() {
        for(int i=0;i<110;i++) { // checks collision of ball with bricks
            if (!BrickLoader.brickArr[i].getStatus() && BrickLoader.brickArr[i].colDetect(this)) {
                BrickLoader.brickArr[i].colResponse(this);
                break;
            }
        }
    }
}
