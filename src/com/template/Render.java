package com.template;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

public class Render extends Game {
	
	public static float xOffset;
	public static float yOffset;
	
	public static void render() {
		Display.update();
		Display.sync(120);
		
		//Clear previous display
		glClear(GL_COLOR_BUFFER_BIT);
		
		//Bind texture
		texture.bind();
		
		//Draw rectangle
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0.0F + xOffset, 0.0F + yOffset);
		glTexCoord2f(1, 0);
		glVertex2f(16.0F + xOffset, 0.0F + yOffset);
		glTexCoord2f(1, 1);
		glVertex2f(16.0F + xOffset, 19.0F + yOffset);
		glTexCoord2f(0, 1);
		glVertex2f(0.0F + xOffset, 19.0F + yOffset);
		glEnd();
    }
}