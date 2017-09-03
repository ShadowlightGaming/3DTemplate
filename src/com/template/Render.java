package com.template;

import static org.lwjgl.opengl.GL11.*;

public class Render extends Game {
	
	public static float xOffset;
	public static float yOffset;
	
	public static void render() {
		//Clear previous display
		glClear(GL_COLOR_BUFFER_BIT);
		switch (state) {
		case INTRO:
			glColor3f(1.0f, 0.0f, 0.0f);
			glRectf(0, 0, WIDTH, HEIGHT);
			break;
		case GAME:
			glColor3f(0.0f, 1.0f, 0.0f);
			glRectf(0, 0, WIDTH, HEIGHT);
			break;
		case MAIN_MENU:
			glColor3f(0.0f, 0.0f, 1.0f);
			glRectf(0, 0, WIDTH, HEIGHT);
			break;
		}/**
		//Bind texture
		texture.bind();
		
		//Draw rectangle
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0.0F + xOffset, 0.0F + yOffset);
		glTexCoord2f(1, 0);
		glVertex2f(16.0F + xOffset, 0.0F + yOffset);
		glTexCoord2f(1, 1);
		glVertex2f(16.0F + xOffset, 8.0F + yOffset);
		glTexCoord2f(0, 1);
		glVertex2f(0.0F + xOffset, 8.0F + yOffset);
		glEnd();*/
    }
}