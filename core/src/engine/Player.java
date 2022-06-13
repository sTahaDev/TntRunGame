package engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Player {
    SpriteBatch batch;
    Texture picture;
    String url;
    public int playerX;
    public int playerY;
    int playerW;
    int playerH;
    public Rectangle playerRectangle;
    boolean isMoveable;
    public int playerSpeed = 10;

    public Player(int x,int y,String url, boolean isMoveable){
        playerX = x;
        playerY = y;
        this.url = url;
        this.isMoveable = isMoveable;

    }
    public void PlayerCreate(){
        batch = new SpriteBatch();
        picture = new Texture(url);

        playerW = picture.getWidth();
        playerH = picture.getHeight();
    }
    public void RenderPlayer(){
        batch.begin();
        batch.draw(picture, playerX, playerY);
        batch.end();
        playerRectangle = getBounds();
        PlayerMove();
    }

    private void PlayerMove() {
        if (isMoveable == true){
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                playerX += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                playerX -= playerSpeed;
            }
            /*
            if (Gdx.input.isKeyPressed(Input.Keys.UP)){
                playerY += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                playerY -= playerSpeed;
            }*/
        }

    }

    public Rectangle getBounds(){
        return new Rectangle(playerX, playerY, playerW, playerH);
    }
}
