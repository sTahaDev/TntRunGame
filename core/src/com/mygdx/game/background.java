package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class background {
    int x,y;
    String url;
    SpriteBatch batch;
    Texture img;
    BitmapFont font;
    public background(int x, int y, String url) {
        this.x = x;
        this.y = y;
        this.url = url;
    }
    public void createBG(){
        batch = new SpriteBatch();
        img = new Texture(url);

        font = new BitmapFont(Gdx.files.internal("ab.fnt"),Gdx.files.internal("ab.png"),false);
    }
    public void renderBG(){
        batch.begin();
        batch.draw(img,x,y);
        if (!GameMain.gameover){
            font.draw(batch,"Score: " + GameMain.score, 10, 50);
        }

        batch.end();
    }
}
