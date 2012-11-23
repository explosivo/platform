package com.zachnickell.platform.map.tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.zachnickell.platform.entitiy.Player;

public class GrassTile extends Tile {

	public GrassTile(int x, int y) {
		super(x, y);
		tile = Tile.grass;
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g){
		g.drawImage(tile, x*16, y*16, 16, 16, null);
	}

	
	public void update(){
		if (intersects())
			System.out.println("You're on grass!");
	}
	
}
