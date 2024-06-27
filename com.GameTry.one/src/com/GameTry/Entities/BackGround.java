package com.GameTry.Entities;

import java.awt.Graphics;

import com.GameTry.display.jfx.Assets;

public class BackGround extends Entity{

	public BackGround(float x, float y) {
		super(x, y);
		
	}

	@Override
	public void update() {
		y++;
   if((y+500)%70==0)
    	y-=45;
    	
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.a.get(1),50,(int) y,null);
		
	}
	public int  getY() {
		return (int)y;
	}
}
