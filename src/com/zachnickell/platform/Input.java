package com.zachnickell.platform;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{

	public static boolean upPressed = false;
	public static boolean downPressed = false;
	public static boolean leftPressed = false;
	public static boolean rightPressed = false;
	public static boolean shootUpPressed = false;
	public static boolean shootDownPressed = false;
	public static boolean shootLeftPressed = false;
	public static boolean shootRightPressed = false;
	public static boolean enterPressed = false;
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) upPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_S) downPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_A) leftPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_D) rightPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_UP) shootUpPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN) shootDownPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT) shootLeftPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) shootRightPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_ENTER) enterPressed = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) upPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_S) downPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_A) leftPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_D) rightPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_UP) shootUpPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN) shootDownPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT) shootLeftPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) shootRightPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_ENTER) enterPressed = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}