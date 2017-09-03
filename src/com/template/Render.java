package com.template;

import static org.lwjgl.opengl.GL11.*;

public class Render extends Game {
	
	public static float xOffset;
	public static float yOffset;
	
	public static void render() {
		//Clear previous display
		glClear(GL_COLOR_BUFFER_BIT);
		
		//Display based on game state
		
		
		switch (state) {
		case INTRO:
			glColor3f(1.0f, 0.0f, 0.0f);
			glRectf(0, 0, WIDTH, HEIGHT);
			
			texFractal.bind();
			box.draw();
			break;
		case GAME:
			glColor3f(0.0f, 1.0f, 0.0f);
			glRectf(0, 0, WIDTH, HEIGHT);

			texClouds.bind();
			box.draw();
			break;
		case MAIN_MENU:
			glColor3f(0.0f, 0.0f, 1.0f);
			glRectf(0, 0, WIDTH, HEIGHT);
			
			texClouds.bind();
			box.draw();
			break;
		}
    }
}