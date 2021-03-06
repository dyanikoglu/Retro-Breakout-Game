package com.dyanikoglu.retrobreakout;

import com.dyanikoglu.retrobreakout.GameObject.GameObject;

import java.awt.*;
public class Display extends GameObject {
    private String[] uSplitArr;
    private String[] sSplitArr;
    private String name;

    public void read(String str,Graphics g, int x, int y) {
        this.setX(x);
        this.setY(y);
        name = str.replaceAll("ı","i");
        uSplitArr = name.split("");
        for(int i=0;i<uSplitArr.length;i++) {
            drawToPanel(uSplitArr[i], g, i);
        }
    }

    public void read(int score,Graphics g, int x, int y) {
        this.setX(x);
        this.setY(y);
        sSplitArr = Integer.toString(score).split("");
        for(int i=0;i<sSplitArr.length;i++) {
            drawToPanel(sSplitArr[i], g, i);
        }
    }

    private void drawToPanel(String letter,Graphics g,int i) {
        if(letter.equalsIgnoreCase(" ")) {
            return;
        }
        if(GamePanel.endGame==1) { //Print Red Text
            setIcon(loader.getResource("image/" + letter + "2" + ".png"));
            g.drawImage(this.getImage(), this.getX() + i * 16, this.getY(), 12, 16, null);
        }
        else { //Print Green Text
            setIcon(loader.getResource("image/" + letter + ".png"));
            g.drawImage(this.getImage(), this.getX() + i * 16, this.getY(), 12, 16, null);
        }
    }
}
