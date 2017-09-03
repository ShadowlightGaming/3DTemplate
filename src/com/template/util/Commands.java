package com.template.util;

import java.util.ArrayList;

public class Commands {
	static ArrayList<String> commands = new ArrayList<>();
	static ArrayList<String> commandsUse = new ArrayList<>();
	static ArrayList<String> commandsDesc = new ArrayList<>();
	
	//Add command name, use, and description to  arrays
	public static void add(String command, String commandUse, String commandDesc) {
		commands.add(command);
		commandsUse.add(commandUse);
		commandsDesc.add(commandDesc);
	}
	
	//Get ID via command name
	public static int getID(String command) {
		int spaces = 0;
		int s1 = command.length();
		//Go through string look for a space
		for(int j = 0; j < command.length(); j++) {
			if(command.charAt(j) == ' ') {
				//If a space is found, set s1 to the position of that space
				spaces++;
				if(spaces == 1) {
					s1 = j;
				}
			}
		}
		//Set the string to end at the first space
		command = command.substring(0, s1);
		
		//return ID of command
		if(command.equals(commands.get(0))) {
			return 0;
		} else if(command.equals(commands.get(1))) {
			return 1;
		} else {
			return 2;
		}
	}
	
	//Run Command
	public static void run(String command) {
		//Get ID of command
		int num = getID(command);
		
		int spaces = 0;
		int s1 = command.length();

		//Go through string look for a space
		for(int j = 0; j < command.length(); j++) {
			if(command.charAt(j) == ' ') {
				//If a space is found, set s1 to the position of that space
				spaces++;
				if(spaces == 1) {
					s1 = j;
				}
			}
		}
		
		//Get sub command (string of text after first space)
		String sub = command.substring(s1).trim();
		
		//Execute command
		switch(num) {
		//help
		case 0:
			//Print all commands names, uses, and descriptions
			for(int i = 0; i < commands.size(); i++) {
				Log.out(commandsUse.get(i) + ": " + commandsDesc.get(i));
			}
			break;
		case 1:
			break;
		default:
			Log.warning("Unkown Command");
			break;
		}
	}
}
