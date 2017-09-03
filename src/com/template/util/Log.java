package com.template.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Log {
	static File folder = new File("logs");
	
	//This Method logs text. Equivalent to System.out
	public static void out(String string) {
		//Get Current time
		LocalDateTime time = LocalDateTime.now();
		//Get origin of string
		String origin = new Exception().getStackTrace()[1].getClassName().substring(13);
		//Set string to print
    	String print = 
    			"[" + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + "] " + 
    	    			origin + ": " + 
    	    			string;
    	
    	//Print string to console
    	System.out.println(print);
    	//Print string to log
    	log(print);
    }
	
	//This Method logs errors. Equivalent to System.err
	public static void error(Exception e) {
		//Get Current time
		LocalDateTime time = LocalDateTime.now();
		//Get origin of string
		String origin = new Exception().getStackTrace()[1].getClassName().substring(13);
		//Set string to print		
		String print =
    			"[" + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + "] " + 
    			origin + ": " + 
    			e;

		//Print string to console
    	System.err.println(print);
		e.printStackTrace();
		//Print string to log
		log(print);
    }
	
	//This Method is made to print problems that don't have errors attached to them
	public static void warning(String string) {
		//Get Current time
		LocalDateTime time = LocalDateTime.now();
		//Get origin of string
		String origin = new Exception().getStackTrace()[1].getClassName().substring(13);
		//Set string to print		
		String print =
    			"[" + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + "] " + 
    			origin + ": " + 
    			string;
		
		//Print string to console
    	System.err.println(print);
    	//Print string to log
    	log(print);
    }
	
	//This Method dumps the text from latest.log to a time-stamped log file
	public static void dump() {
		//Get Current time
		LocalDateTime time = LocalDateTime.now();
		//Check if folder exists
		if(!folder.exists()) {
			//If folder doesn't exist, create it
			folder.mkdirs();
		}
		//Set path of file to copy from
		Path oldFilePath = Paths.get(folder +"/latest.log");
		//Set path of file to copy to
		Path newFilePath = Paths.get(folder + "/" + time.getDayOfMonth() + "." + time.getMonthValue() + "." + time.getYear() + "_" + time.getHour() + "." + time.getMinute() + "." + time.getSecond() + ".log");
    	
		//Open buffer writer
		try(BufferedWriter writer = Files.newBufferedWriter(newFilePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.WRITE)) {
    		@SuppressWarnings("resource")
    		//Copy text over line-by-line
			Scanner scanner = new Scanner(oldFilePath);
    		while(scanner.hasNextLine()) {
    			writer.write(scanner.nextLine());
    			writer.newLine();
    		}
    	} catch(IOException e) {
    		//Print execption
    		e.printStackTrace();
    	}
		
		//Delete extra logs
		delLogs();
	}
	
	//This Method deletes log files over a certain number dictated by a config
	private static void delLogs() {
		//Set directory of logs
		File f = new File("logs");
		//Get array of all files in dir
		String[] logs = f.list();
		
		//Tests if the number of files in dir is greater than the number of files to keep dictated by config
		if(logs.length - 1 > (Integer.parseInt(Config.get("keeplogs")))) {
			//Set latest file to be deleted
			File del = new File(f + "/" + logs[0]);
			//Delete file
			del.delete();
			//Log file deletion
			Log.out("Deleted " + logs[0]);
			//Reiterate incase config has been changed
			delLogs();
		}
	}
	
	//This Method resets all the text in a file
	public static void reset(String fileName) {
		//Check if folder exists
		if(!folder.exists()) {
			//If folder doesn't exist, create it
			folder.mkdirs();
		}
		//Set path based on file name
    	Path filePath = Paths.get(folder + "/" + fileName);
    	
    	//write nothing to file to make it blank
    	try(BufferedWriter writer = Files.newBufferedWriter(filePath)) {
    		writer.write("");
    	} catch(IOException e) {
    		//Log errors
    		Log.error(e);
    	}
	}
	
	//This Method logs everything that is printed to the console in a log file
	public static void log(String print) {  
		//Check if folder exists
		if(!folder.exists()) {
			//If folder doesn't exist, create it
			folder.mkdirs();
		}
		//Set path to latest.log
	  	Path filePath = Paths.get(folder + "/latest.log");
	  	//Write string that gets printed to console
    	try(BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.WRITE)) {
    		writer.write(print);
    		writer.newLine();
    	} catch(IOException e) {
    		//Log errors
    		Log.error(e);
    	}
	}
}
