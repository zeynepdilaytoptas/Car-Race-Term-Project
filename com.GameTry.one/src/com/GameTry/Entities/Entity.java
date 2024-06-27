package com.GameTry.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.GameTry.display.jfx.Assets;

public abstract class Entity{
	protected float x,y;//calculation wont be int so float
	protected Rectangle bounds;

	Assets se=new Assets();
 
	public Entity(float x,float y) {
		this.x=x;
		this.y=y;
		
	 bounds=new Rectangle(se.a.get(0).getHeight(null),se.getWidthBike());
	
	
	}
	










	public abstract void update();
	public abstract void render(Graphics g);
	
	

}
