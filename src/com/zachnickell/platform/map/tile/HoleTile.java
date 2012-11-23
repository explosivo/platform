package com.zachnickell.platform.map.tile;

public class HoleTile extends Tile {

	public HoleTile(int x, int y) {
		super(x, y);
		tile = Tile.hole;
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		if (intersects())
			System.out.println("You're in a hole!");
	}

}