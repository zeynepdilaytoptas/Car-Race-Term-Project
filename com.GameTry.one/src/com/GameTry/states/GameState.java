package com.GameTry.states;
import java.awt.Graphics;

import com.GameTry.Entities.BackGround;
import com.GameTry.Entities.PlayerBike;
import com.GameTry.display.jfx.Assets;
import com.GameTry.one.MainGameClass;

// Oyun baþlangýcýna özel olan state
public class GameState extends State {
	
	private BackGround back1,back2;
	private PlayerBike pb;// constructor dýþýnda gözüüksün diye
	public GameState(MainGameClass mg) {
		super(mg);
		pb = new PlayerBike(mg, 100, 200);
		back1=new BackGround(50,100);
		back2=new BackGround(50,-400);
	   }

	public void update() {
		pb.update();
		back1.update();
		back2.update();
		System.out.println("y si "+back1.getY());
		System.out.println("back2 nun"+back2.getY());
		
	
	}

	public void render(Graphics g) {
		
	   back1.render(g);
	   back2.render(g);
	   pb.render(g);
		/// g.drawImage(Assets.a.get(0),300,220,null);
	
	}

}
