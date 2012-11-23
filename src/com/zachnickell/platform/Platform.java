package com.zachnickell.platform;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;

import com.zachnickell.platform.entitiy.Enemy;
import com.zachnickell.platform.entitiy.Player;
import com.zachnickell.platform.map.Floor;
import com.zachnickell.platform.map.tile.Tile;

public class Platform extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static String name = "Platform";
	public static String version = "Pre-Alpha 0.01";
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	public static int FRAMES;
	public static int fps;
	
	public long lastFrame; 
	
	
	public static boolean running = false;
	public static boolean isPaused = false;
	
	private BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private Graphics dbg = null;

	Player player = new Player();
	Floor floor = new Floor();
	
	public static String title(){
		String title;
		title = name + " " + version;
		return title;
	}
	
	public long getTime() {
	    return System.nanoTime() / 1000000;
	}
	
	public int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
	 
	    return delta;
	}
	
	public void start(){
		if (!running){
			floor.createFloor();
			addKeyListener(new Input());
			requestFocus();
			running = true;
			new Thread(this).start();
		}
	}
	
	public void run(){
		long lastTime = System.currentTimeMillis();
		int sleepTime = 15;
		while(running){
			int delta = getDelta();
			gameUpdate(delta);
			render();
			drawFrame();
			if (System.currentTimeMillis() - lastTime >= 1000){
				System.out.printf("fps: %d dt: %d\n", FRAMES, delta);
				lastTime += 1000;
				fps = FRAMES;
				FRAMES = 0;
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void gameUpdate(int delta){
		if (!isPaused){
			player.update(delta);
			if(Input.enterPressed)
				floor.createFloor();
			floor.update();
		}
	}
	
	public void render(){
		dbg = img.createGraphics();
		dbg.setColor(Color.BLUE);
		dbg.fillRect(0, 0, WIDTH, HEIGHT);
		dbg.translate((int)-Player.x + 320 / 2 - Player.w/2, (int)-Player.y + 240 / 2 - Player.w);
		floor.render(dbg);
		player.render(dbg);
		dbg.setColor(Color.WHITE);
		dbg.drawString("fps: " + fps, (int)Player.x - 320 / 2 + Player.w/2, (int)Player.y - 240 / 2 + 15);
		dbg.dispose();
	}
	
	public void drawFrame(){
		FRAMES++;
		Graphics g = getGraphics();
		g.drawImage(img, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g.dispose();
	}
	
	public static void main(String[] args){
		Platform platform = new Platform();
		JFrame win = new JFrame(title());
		win.add(platform);
		win.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		platform.start();
	}
}
