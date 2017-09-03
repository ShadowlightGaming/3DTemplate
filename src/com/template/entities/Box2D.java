package com.template.entities;

import static org.lwjgl.opengl.GL11.*;

import com.template.entities.Entity.Entity2D;

public class Box2D extends Entity implements Entity2D {
	protected float x;
	protected float y;
	protected float size;
	
	public Box2D(float x, float y, float size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public Box2D() {
		this.x = 0;
		this.y = 0;
		this.size = 0;
	}
	

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void create() {
		// We don't need anything here for a box
	}
	@Override
	public void destroy() {
		// We don't need anything here for a box
	}
	@Override 
	public void draw() {
		glBegin(GL_QUADS);
			glColor4f(1, 1, 1, 0.5F);
			glVertex2f(x - size / 2, y - size / 4);
			glTexCoord2f(0, 0);
			glVertex2f(x - size / 2, y + size / 4);
			glTexCoord2f(1, 0);
			glVertex2f(x + size / 2, y + size / 4);
			glTexCoord2f(1, 1);
			glVertex2f(x + size / 2, y - size / 4);
			glTexCoord2f(0, 1);
		glEnd();
	}
}
