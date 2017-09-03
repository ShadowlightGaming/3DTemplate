package com.template.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
	static File folder = new File("config.properties").getAbsoluteFile().getParentFile();
	static Properties config = new Properties();
	
	//Add config property
	public static void add(String value, String variable) {
		//Check if folder exists
        if(!folder.exists()) {
            try {
            	//Create it if it doesn't
                folder.mkdirs();
            } catch(SecurityException e) {
            	//Log Errors
                Log.error(e);
            }
        }
        
        OutputStream output = null;
        //Set path of config file
        Path filePath = Paths.get(folder + "/config.properties");
        //Test if property exists
  		if (get(value).equals("")) {
  			try {
  				//Create proptery and add it to file if it doesn't exist
  				output = new FileOutputStream(filePath + "");
  				config.put(value, variable);
  			} catch(IOException e) {
  				//Log Errors
  				Log.error(e);
  			} finally {
  				if(output !=null) {
  					try {
  						//Close output file
  						output.close();
  					} catch(IOException e) {
  						//Log errors
  						Log.error(e);
  					}
  				}
  			}
  		}
    }
	//Get config property
	public static String get(String value) {
		InputStream input = null;
		String string = "";
		
		try {
			//Set config file dir
			input = new FileInputStream(folder + "/config.properties");
			
			//Load config file
			config.load(input);
			
			//Test if config contains anything
			if(!config.isEmpty()) {
				//Test if config contains value to be returned
				if(!(config.contains(value))) {
					//Get property value
					string = config.getProperty(value);
					//Can't return a null string
					if(string == null) {
						string = "";
					}
				}
			}
		} catch(IOException e) {
			//Log errors
			Log.error(e);
		}
		//Return string
		return string;
	}
	
	//Store value of propeties
	public static void store() {    	
		OutputStream output = null;
	  	
		try {
			//Set cofing file dir
			output = new FileOutputStream(folder + "/config.properties");

			//Save config file
			config.store(output, null);
		} catch(IOException e) {
			//Log errors
			Log.error(e);
		} finally {
			if(output != null) {
				try {
					//Close output
					output.close();
				} catch(IOException e) {
					//Log errors
					Log.error(e);
				}
			}
		}
	}
}
