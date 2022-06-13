package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import engine.*;


import java.awt.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameMain extends ApplicationAdapter {




	Music music;
	Player player1 = new Player(350,70,"player.png", true);

	background bg = new background(0,0,"bg.png");

	SpriteBatch batchbg;
	Texture imgbg;

	LinkedList<Tnt> bulletlist = new LinkedList<Tnt>();

	int RastegeleX;
	Random rm = new Random();

	int sayac = 0;
	Timer mytimer = new Timer();
	TimerTask gorev1;
	float UretmeSaniyesi = 3;
	public static boolean gameover = false;
	public static int score = 0;
	BitmapFont font2;
	boolean scorestop = false;


	@Override
	public void create () {
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.play();
		player1.PlayerCreate();


		gorev1 = new TimerTask() {
			@Override
			public void run() {
				if (scorestop == false){
					score ++;
				}
				sayac++;

			}
		};
		mytimer.schedule(gorev1,0, 1000);
		bg.createBG();
		batchbg = new SpriteBatch();
		imgbg = new Texture("gm2.png");
		font2 = new BitmapFont(Gdx.files.internal("ab.fnt"),Gdx.files.internal("ab.png"),false);






	}

	@Override
	public void render () {
		//-------------------------------------------
		ScreenUtils.clear(1, 1, 1, 1);
		//-----------------------------------
		if (gameover == false){
			bg.renderBG();
			player1.RenderPlayer();




			if (sayac >= UretmeSaniyesi){

				RastegeleX = rm.nextInt(900);
				bulletlist.add(new Tnt(RastegeleX, 601, "tnt.png"));
				bulletlist.getLast().tntCreate();

				UretmeSaniyesi -= 0.1;
				sayac = 0;

			}
			if (UretmeSaniyesi < 1){
				UretmeSaniyesi = 1;
				player1.playerSpeed = 2;
			}
			if (UretmeSaniyesi <2){
				player1.playerSpeed = 5;
			}
			if (UretmeSaniyesi < 2.5){
				player1.playerSpeed = 7;
			}





		/*if (player1.playerRectangle.intersects(player2.playerRectangle.getBounds())){
			System.out.println("IT WORKSS !!!!");
		}*/
		/*if (Gdx.input.isKeyJustPressed(Input.Keys.F)){


			bulletlist.add(new Tnt(player1.playerX, player1.playerY, "tnt.png"));
			bulletlist.getLast().tntCreate();

		}*/
			for (int i = 0; i < bulletlist.size(); i++) {

				bulletlist.get(i).TntRender();

				if (player1.playerRectangle.intersects(bulletlist.get(i).getBounds())){
					gameover = true;

				}
			}

		}
		else if (gameover == true){


			scorestop = true;
			batchbg.begin();
			batchbg.draw(imgbg,0,0);
			font2.setColor(new Color(Color.BLACK));
			font2.draw(batchbg,"YOUR SCORE: " + score, 270, 250);
			batchbg.end();
			if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
				scorestop = false;
				score = 0;
				bulletlist.clear();
				player1.playerSpeed = 10;
				UretmeSaniyesi = 3;
				gameover = false;
				System.out.println("ENTER BASILDI");
			}


		}



	}
	
	@Override
	public void dispose () {

	}
}
