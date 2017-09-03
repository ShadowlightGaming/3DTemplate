package com.template;

import org.lwjgl.input.Keyboard;

import com.template.util.Log;

public class Tick extends Game{
	//100 ticks = 1 second
	public static int tickCount = 0;
		
	public static void tick() {
		tickCount++;
		Log.out(tickCount + "");
	}
	
	
	public static void inputTick() {
		//Move screen via arrow keys
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			box.setX(box.getX() + 1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			box.setX(box.getX() - 1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			box.setY(box.getY() + 1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			box.setY(box.getY() - 1);
		}
		
		while (Keyboard.next()) {
			//Exit game when esc is pressed
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
				running = false;
			}
			//Change Game state when space is pressed
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				if(state == State.INTRO){
					state = State.MAIN_MENU;
				} else if(state == State.MAIN_MENU) {
					state = State.GAME;
				} else if(state == State.GAME){
					state = State.INTRO;
				}
				Log.out("State changed to " + state);
			}
		}
	}
}
