package com.dyanikoglu.retrobreakout.GameObject.Paddle;

import com.dyanikoglu.retrobreakout.GameObject.Ball;
import com.dyanikoglu.retrobreakout.GameObject.GameObject;
import com.dyanikoglu.retrobreakout.ICollidable;
import com.dyanikoglu.retrobreakout.Point;
import com.dyanikoglu.retrobreakout.Sound;

import java.awt.event.KeyEvent;
 import java.lang.Math;
public class Paddle extends GameObject implements ICollidable {
/**
    * padType 0 : NormalPaddle
    * padType 1 : LargePaddle
    * padType 2 : JumpyPaddle
*/
    private int padType;
    private int padDir;

    public void move(Ball ball) { // moves paddle and checks collision with ball
        this.colResponse(ball);

        this.setX(this.getX() + this.padDir);
        if (this.getType() != 1 && this.getX() >= 496)
            this.setX(496);
        else if (this.getType() == 1 && this.getX() >= 432)
            this.setX(432);
        if (this.getX() <= 0)
            this.setX(0);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            this.padDir = -5;
        if (e.getKeyCode()  == KeyEvent.VK_RIGHT)
            this.padDir = 5;
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            this.padDir = 0;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            this.padDir = 0;
    }

    public int getType() {
        return padType;
    }

    private void setType(Paddle paddle) {
        if (Math.random() < 0.1 && paddle.getType() != 2) { // %10 chance
            if (Math.random() < 0.5 && paddle.padType!=1) {
                Sound.Play(loader.getResource("sound/pwrup.wav"));
                paddle.padType = 1;
            }
            else if(paddle.padType!=2) {
                Sound.Play(loader.getResource("sound/pwrup.wav"));
                paddle.padType = 2;
            }
        }

        else if (paddle.getType() != 1) {
            paddle.padType = 0;
        }
    }

    private void applyType(Paddle paddle) {
        if (paddle.getType() == 0) {
            NormalPaddle.set(paddle);
        }
        else if (paddle.getType() == 1) {
            LargePaddle.set(paddle);
        }
        else if (paddle.getType() == 2) {
            JumpyPaddle.set(paddle);
        }
    }

    public boolean colDetect(Ball ball) {
        return (Point.dirY > 0 && ball.getRect().intersects(this.getRect()));
    }

    public void colResponse(Ball ball) {
        if (colDetect(ball)) {
            if(getType()==2)
                Sound.Play(loader.getResource("sound/spdup.wav"));
            else
                Sound.Play(loader.getResource("sound/paddle.wav"));

            Point.dirY = -Point.dirY;
            if (getType() == 2) {
                Point.velY++;
                Point.velX++;
            }
            setType(this);
            applyType(this);
        }
    }
}