package com.GameTry.Entities;

import java.awt.Color;
import java.awt.Graphics;

import com.GameTry.display.jfx.Assets;
import com.GameTry.one.MainGameClass;

public class PlayerBike extends Entity{
  private int health=100;
	private MainGameClass mgc;
	public PlayerBike(MainGameClass mg,float x, float y) {
		super(x, y);
		this.mgc=mg;
	
	
	}
	public void update() {
		bounds.x=(int) x;
		bounds.y=(int) y;
	if(mgc.getKeyMngr().left) {
        if(bounds.getX()>45)
		this.x-=10;
   //     else;
        
	}else if (mgc.getKeyMngr().right) {
		 if(bounds.getX()<455)  
		    this.x+=10;
		  }
	System.out.println("bisiklet x"+x);
	}	
	public void render(Graphics g) {
			g.drawImage(Assets.a.get(0),(int)x,(int)y,null);
		  g.setColor(Color.BLUE);
	g.fillRect(bounds.x,bounds.y,(int)bounds.getWidth(),(int)bounds.getHeight());
	}

	/*public gainHealth() {
		if(iscollide())
			health+=10;
	}*/

}
