package com.GameTry.display.jfx;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Assets {

	public static ArrayList<Image> a=new ArrayList<Image>(); 

	// will load everything once then use everywhere 
	public static void init() {
	try {
		Image background1= ImageLoader.loadImage("/ýmg/Background.jpg");
		//Image randomImg=ImageLoader.loadImage("/ýmg/bike.png");
		Image bike1= ImageLoader.loadImage("/ýmg/bike.png");
		bike1=  bike1.getScaledInstance(100,100,((BufferedImage) bike1).getType());//
		background1=background1.getScaledInstance(500,500,((BufferedImage) background1).getType());
	
		 a.add(bike1);
		 a.add(background1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
         
	}

public   int getWidthBike() {
	return a.get(0).getWidth(null);
}



}
