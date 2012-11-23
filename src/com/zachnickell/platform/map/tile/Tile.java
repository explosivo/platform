package com.zachnickell.platform.map.tile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.zachnickell.platform.entitiy.Player;
import com.zachnickell.platform.map.Floor;

public class Tile {

	BufferedImage tile;
	public static BufferedImage grass;
	public static BufferedImage hole;
	public static BufferedImage tree;
	public static BufferedImage rock;
	int x, y;
	
	public static void initSprites(){
		try {
			grass = ImageIO.read(Floor.class.getResource("/grass.png"));
			hole = ImageIO.read(Floor.class.getResource("/hole.png"));
			tree = ImageIO.read(Floor.class.getResource("/tree.png"));
			rock = ImageIO.read(Floor.class.getResource("/rock.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Tile(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g){
		g.drawImage(tile, x*16, y*16, 16, 16, null);
	}
	
	public boolean intersects(){
		Rectangle a = new Rectangle(this.x*16, this.y*16, 16, 16);
		if(a.intersects(Player.x, Player.y, Player.w, Player.h))
			return true;
		else return false;
	}
	
	public void update(){
	}
}
