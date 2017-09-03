package com.template.entities;

public class Entity {
	public interface Entity2D {
		public float getX();
		public float getY();
		public void setX(float x);
		public void setY(float y);
		public void setLocation(float x, float y);
		public void create();
		public void destroy();
		public void draw();
	}
}
