package com.template;

import com.template.util.Commands;
import com.template.util.Config;
import com.template.util.Log;

public class Main {
		
	public static void main(String[] args) {
		//Reset Latest Log
		Log.reset("latest.log");
		//Add config values if none exist
		addConfig();
		//Add commands used while in app
		addCommands();

		//Initialize game
		Game.init();
		//Run game loop
		Game.run();
	}
	
	public static void addCommands() {
		//Add help command to list all commands
		Commands.add("help", "help", "Displays all commands");
		Log.out("Help command added");
		
		Log.out("Commands loaded");
	}
	
	public static void addConfig() {
		//How many logs do you want to keep?
		Config.add ("keeplogs", "5");
		//Do you want to show fps?
		Config.add("showfps", "true");
		//Save configs
		Config.store();
		//Log that the config is loaded
		Log.out("Configuration loaded");
	}
}
