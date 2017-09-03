package com.template.handlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.lwjgl.opengl.Display;

import com.template.Game;
import com.template.util.Log;

public class EventHandler extends Game {
	
	/**
	 * newGame(), loadSave(), and save(), are all placeholder methods. They are there for use, but
	 * they need to be heavily modified to fit the requires of the game before they can be used.
	 */
	//Create new game file
	public static void newGame() {
		try {		
			//Set new game file dir
			FileOutputStream save = new FileOutputStream("resources/saves/game.save");
			Properties properties = new Properties();
				//Deafault game values
			
			//Create new game file
			properties.store(save, null);
		//Catch Errors
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Load a save file
	public static void loadSave() {
		try {
			//Set file to load
			FileInputStream save = new FileInputStream("resources/saves/game.save");
	        
			//Load file
			Properties properties = new Properties();
	        properties.load(save);
	        	//Information to load
	        
	        //Close load file
	        save.close();
        //Catch Errors
		} catch (FileNotFoundException e) {
			Log.error(e);
		} catch (IOException e) {
			Log.error(e);
		}
	}
	
	//Save a game file
	public static void save() {
		try {
			//Set save file
			FileOutputStream save = new FileOutputStream("resources/saves/game.save");
			Properties properties = new Properties();
				//Information needed to save game
			
			//Store properties in save file
			properties.store(save, null);
		//Catch Errors
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	//Shutdown program
	public static void shutdown() {
		//Log Shutdown process
		Log.out("Shutting down");
		//Dump Log
    	Log.dump();
    	//Destroy window
    	Display.destroy();
    	//Exit System
    	System.exit(0);
	}
}
