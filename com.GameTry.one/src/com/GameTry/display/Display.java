)package com.GameTry.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Canvas;
import javax.swing.JFrame;

public class Display {
	
	public static String getTitle() {
		return title;
	}

	public static int getHeight() {
		return height;
	}

	public static int getWidth() {
		return width;
	}

	Color randColor = new Color(201,200,0);
public Canvas getCanvas() {
	return canvas;
}
private JFrame frame;
private Canvas canvas;// container of image like

private static   String  title="HARD DRIVE";// static fieldda static method ulaþabilir.
private  static int height=500,width=600;// in picsel HEIGHT,WIDTH

//Constructor of display
public Display () //sort of camera
{
 createDisplay();
}

private void createDisplay() {
	frame=new JFrame();
   
	frame.setTitle(title);
	frame.setSize(width,height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// by defauelt it setted that when hit close button visual gone but at background it still works.
	frame.setResizable(true);
	frame.setLocationRelativeTo(null);// null olunca ortaya göre ayarlýyor.
	frame.setVisible(true);// as a default it setted to be false so non visible ?? 
	// check other methods frame.
	// title width height  at construcotr then create display method 
	// use JFrane setSize and default close op  setVisible(true)
    
	canvas=new Canvas();
	
	//Dimension.class
    canvas.setPreferredSize(new Dimension(width,height));
    canvas.setMaximumSize(new Dimension(width,height));
    canvas.setMinimumSize(new Dimension(width,height));
    canvas.setFocusable(false);//by defauly its true dont show the movement
    frame.add(canvas);//adds canvas to our frame	
    frame.pack();// it resize  frame to match with canvas so canvas final frame resizable
    
}
public JFrame getFrame(){
	return this.frame;
}
	
}
