package com.zachnickell.platform.map.tile;

public class TreeTile extends Tile{

	public TreeTile(int x, int y) {
		super(x, y);
		tile = Tile.tree;
		// TODO Auto-generated constructor stub
	}

	public void update(){
		if (intersects())
			System.out.println("You're on a tree!");
	}
	
}
