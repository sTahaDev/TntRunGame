package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.LinkedList;

public class Tnt {
    int tntX,tntY;
    String tntURL;
    SpriteBatch batch;
    Texture img;
    int tntW,tntH;
    public Rectangle tntRec;

    public Tnt(int x,int y, String url){
        tntX = x;
        tntY = y;
        tntURL = url;

    }
    public void tntCreate(){
        batch = new SpriteBatch();
        img = new Texture(tntURL);
        tntW = img.getWidth();
        tntH = img.getHeight();
    }
    public void TntRender(){
        batch.begin();
        batch.draw(img,tntX,tntY);
        batch.end();
        tntY -= 10;
        tntRec = getBounds();
    }
    public Rectangle getBounds(){
        return new Rectangle(tntX, tntY, tntW, tntH);
    }



}
