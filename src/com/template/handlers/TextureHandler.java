package com.template.handlers;

import java.io.*;

import org.newdawn.slick.opengl.*;

import com.template.Game;
import com.template.util.Log;

public class TextureHandler extends Game {
	static String[] img = new String[2];
	static String[] id = new String[2];
	
	public static void init() {
		try {
			texClouds = TextureLoader.getTexture("PNG",  new FileInputStream(new File("res/textures/Clouds.png")));
			texFractal = TextureLoader.getTexture("PNG",  new FileInputStream(new File("res/textures/Fractal.png")));
		} catch (FileNotFoundException e) {
			Log.error(e);
		} catch (IOException e) {
			Log.error(e);
		}
		
		id[1] = texClouds.toString();
		id[0] = texFractal.toString();
		Log.out(id + "");
		img[1] = "Clouds.png";
		img[0] = "Fractal.png";
	}
	
	public static void bind(Texture tex) {
		try {
			tex = TextureLoader.getTexture("PNG",  new FileInputStream(new File("res/textures/" + img[getID(tex)])));
		} catch (FileNotFoundException e) {
			Log.error(e);
		} catch (IOException e) {
			Log.error(e);
		}
	}

	public static int getID(Texture tex) {
		for(int i = 0; i < id.length; i++) {
			if(id[i].equals(tex.toString())) {
				return i;
			}
		}
		return -1;
	}
}
