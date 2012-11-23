package com.zachnickell.platform.entitiy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.zachnickell.platform.Input;

public class Player {
	
	public BufferedImage sprite;
	Random r = new Random();
	public static float x = 0, y = 0;
	public static boolean canMove = true;
	public static int w = 4;
	public static int h = 8;
	
	public Player(){
		try {
			sprite = ImageIO.read(Player.class.getResource("/player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g){
		//g.setColor(Color.RED);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(sprite, (int)x, (int)y, null);
	}
	
	public void update(int delta){
		//System.out.printf("(%d, %d)\n", (int)x, (int)y);
		//bleep controls
		if (canMove){
			if (Input.rightPressed)
				x += 0.05f * delta;
			if (Input.downPressed)
				y += 0.05 * delta;
			if (Input.leftPressed)
				x -= 0.05f * delta;
			if (Input.upPressed)
				y -= 0.05f * delta;
		}
		//keep player on screen
		/*if (x > 320)
			x = 0;
		if (x < 0 - 20)
			x = 320;
		if (y > 240)
			y = 0;
		if (y < 0 - 20)
			y = 200;*/
	}
	
}
