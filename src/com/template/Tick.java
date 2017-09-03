package com.template;

import org.lwjgl.input.Keyboard;

import com.template.handlers.EventHandler;

public class Tick {
	//100 ticks = 1 second
	public int tickCount = 0;
		
	public void tick() {
		tickCount++;
	}
	
	
	@SuppressWarnings("static-access")
	public static void inputTick() {
		//Exit game when esc is pressed
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			EventHandler.shutdown();
		}
		//Move screen via arrow keys
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			Render.xOffset += 0.01F;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			Render.xOffset -= 0.01F;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			Render.yOffset += 0.01F;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			Render.yOffset -= 0.01F;
		}
	}
}
