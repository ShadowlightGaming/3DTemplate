package com.template;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.template.entities.Box2D;
import com.template.entities.Entity.Entity2D;
import com.template.handlers.EventHandler;
import com.template.handlers.TextureHandler;
import com.template.util.Log;

public class Game {	
	public static boolean running = true;
	//Game states
	public enum State {INTRO, GAME, MAIN_MENU};
	public static State state = State.INTRO;
	
	//Window width  height
	public static int WIDTH;
	public static int HEIGHT;
	
	//Frames per second
	public static int fps;
	
	//Textures
	public static Texture texClouds;
	public static Texture texFractal;
	
	//Entities
	static Entity2D box = new Box2D(960, 540, 750);
	
	//Initialization
	public static void init() {
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
		
		//Path the texutres
		TextureHandler.init();
		
		//Enable the textures
		glEnable(GL_TEXTURE_2D);
		
		//Initialize entities
		box.create();
	}
	
	public static void run() {
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
		
		//Destory Entities
		box.destroy();
		//Shutdown
		EventHandler.shutdown();
	}
}
