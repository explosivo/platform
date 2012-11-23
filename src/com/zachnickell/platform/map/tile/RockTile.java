package com.zachnickell.platform.map.tile;

import com.zachnickell.platform.entitiy.Player;

public class RockTile extends Tile {

	public RockTile(int x, int y) {
		super(x, y);
		tile = Tile.rock;
		// TODO Auto-generated constructor stub
	}

	public void update(){
		if (intersects()){
			
		}
	}
	
}
