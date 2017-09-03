package com.template;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.template.handlers.EventHandler;
import com.template.util.Log;

public class Game {	
	public static boolean running = true;
	public enum State {INTRO, GAME, MAIN_MENU};
	public static State state = State.INTRO;
	
	public static int WIDTH = 1920;
	public static int HEIGHT = 1080;
	
	public static int fps;
	
	public static Texture texture = null;
	
	public void init() {
		try {
			//Set program to run in fullscreen mode
			Display.setFullscreen(true);
			//Set display title
			Display.setTitle("3D Testing Window");
			//Create display
			Display.create();
			
			//Get width
			WIDTH = Display.getWidth();
			//Get Height
			HEIGHT = Display.getHeight();
		} catch (LWJGLException e) {
			//Log errors and exit
			Log.error(e);
			EventHandler.shutdown();
		}
		
		//Set projection martix
		glMatrixMode(GL_PROJECTION);
		//Reset previous projection martices
		glLoadIdentity();
		//Set Ortho
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		//Set matrix mode
		glMatrixMode(GL_MODELVIEW);
		
		/**
		 * Please note that any Texture needs to be a power of 2 to render correctly, otherwise it will look funny.
		 * Ex: 16x16; 16384x8192. Any multiple of 2 to 1 (1:1, 2:1, 4:1, 8:1, 16:1, 32:1, 64:1, 128:1, 256:1, 512:1, ect).
		 */
		
		//Path the texutre
		try {
			texture = TextureLoader.getTexture("PNG",  new FileInputStream(new File("resources/textures/Clouds.png")));
		} catch (FileNotFoundException e) {
			Log.error(e);
		} catch (IOException e) {
			Log.error(e);
		}
		
		//Enable the texture
		glEnable(GL_TEXTURE_2D);
	}
	
	public void run() {
		long timer = Sys.getTime();
		int fpsCount = 0;
		while(running) {
			//Update Display
			Display.update();
			//Limit fps to 120
			Display.sync(120);
			
			//Render display
			Render.render();
			//Game input tick
			Tick.inputTick();
			
			//Calculate fps
			if(Sys.getTime() >= timer + 1000) {
				fps = fpsCount;
				fpsCount = 0;
				timer = Sys.getTime();
				Log.out(fps + "");
			}
			fpsCount++;
		}
	}
}
