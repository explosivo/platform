package com.zachnickell.platform.entitiy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	boolean active = true;

	public void render(Graphics g){
		if (active){
			g.setColor(Color.BLACK);
			g.drawRect(0, 20, 20, 20);
		}
	}
	
	public void die(){
		active = false;
	}
	
	public boolean intersects(float x, float y, int w, int h){
		Rectangle a = new Rectangle(0, 20, 20, 20);
		Rectangle b = new Rectangle((int)x, (int)y, w, h);
		if (a.intersects(b))
			return true;
		else
			return false;
	}
	
	public void update(int delta){
		
	}
	
}
