package com.template.util;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	public static Clip clip;
	
	public static void play(String fileName) {
		try {
			//Retrieve Audio clip
			clip = AudioSystem.getClip();
			//Open clip with the file name from resources/sounds folder
			clip.open(AudioSystem.getAudioInputStream(new File(("resources/sounds/" + fileName))));
			//Start playing the auido clip
			clip.start();
			//Log what sound got played
			Log.out("Sound \"" + fileName + "\" played");
		//Handle trown errors
		} catch(UnsupportedAudioFileException e) {
			Log.error(e);
		} catch(LineUnavailableException e) {
			Log.error(e);
		} catch(IOException e) {
			Log.error(e);
		} catch(Exception e) {
			Log.error(e);
		}
	}
	
	public static void pause() {
		//Stop playing last opened audio clip
		clip.stop();
	}
	
	public static void resume() {
		//Start playing last opened audio clip
		clip.start();
	}
	
	public static void stop() {
		//Stop playing last opened audio clip
		clip.stop();
		//Close last opened audio clip
		clip.close();
		//Log that the sound was forcefully stopped
		Log.out("Sound Stopped");
	}
}
