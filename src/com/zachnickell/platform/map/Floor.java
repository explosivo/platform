package com.zachnickell.platform.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.zachnickell.platform.map.tile.GrassTile;
import com.zachnickell.platform.map.tile.HoleTile;
import com.zachnickell.platform.map.tile.RockTile;
import com.zachnickell.platform.map.tile.Tile;
import com.zachnickell.platform.map.tile.TreeTile;

public class Floor {
	
	Graphics dbg;
	BufferedImage img = new BufferedImage(1024, 1024, BufferedImage.TYPE_INT_RGB);
	Random r = new Random();
	int[][] tileGrid = new int[64][64];
	BufferedImage grass;
	BufferedImage hole;
	BufferedImage tree;
	BufferedImage rock;
	
	Tile[][] tiles = new Tile[64][64];
	
	public static final int GRASS = 0;
	public static final int HOLE = 1;
	public static final int TREE = 2;
	public static final int ROCK = 3;
	
	public boolean includeGrass = true;
	public boolean includeHole = true;
	public boolean includeTree = true;
	public boolean includeRock = true;
	
	public void render(Graphics g){
		g.drawImage(img, 0, 0, 1024, 1024, null);
	}
	
	public void update(){
		for (int x = 0; x < 64; x ++){
			for (int y = 0; y < 64; y ++){
				tiles[x][y].update();
			}
		}
	}
	
	public void createFloor(){
		Tile.initSprites();
		System.out.println("creating floor...");
		for (int x = 0; x < 64; x ++){
			for (int y = 0; y < 64; y ++){
				tileGrid[x][y] = r.nextInt(4);
			}
		}
		dbg = img.createGraphics();
		for (int x = 0; x < 64; x ++){
			for (int y = 0; y < 64; y ++){
				includeGrass = true;
				includeHole = true;
				includeRock = true;
				includeTree = true;
				if (x > 0 && y > 0){
					if (tileGrid[x-1][y-1] == HOLE) includeHole = false;
					if (tileGrid[x-1][y-1] == ROCK) includeRock = false;
					if (tileGrid[x-1][y-1] == TREE) includeTree = false;
				}
				if (includeGrass || tileGrid[x][y] == GRASS){
					//dbg.drawImage(hole, 16*x, 16*y, null);
					tiles[x][y] = new GrassTile(x,y);
					tiles[x][y].render(dbg);
				}
				if (includeHole && tileGrid[x][y] == HOLE){
					tiles[x][y] = new HoleTile(x,y);
					tiles[x][y].render(dbg);
				}
				if (includeRock && tileGrid[x][y] == ROCK){
					tiles[x][y] = new RockTile(x,y);
					tiles[x][y].render(dbg);
				}
				if (includeTree && tileGrid[x][y] == TREE){
					tiles[x][y] = new TreeTile(x,y);
					tiles[x][y].render(dbg);
				}
			}
		}
	}
}
