package com.GameTry.display.jfx;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO; ;
public class ImageLoader {

	
public static	Image  loadImage(String path) throws IOException {
	return ImageIO.read(ImageLoader.class.getResource(path));
//takes internal resource , ImageIo.read return buffered Image 
}



}
