package com.GameTry.one;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import com.GameTry.display.Display;
import com.GameTry.display.jfx.Assets;
import com.GameTry.one.Input.KeyMngr;
import com.GameTry.states.GameState;
import com.GameTry.states.MainMenuState;
import com.GameTry.states.State;

/* game loop
 * update
 * render (draw)
 * 
 */
public class MainGameClass implements Runnable {
	private boolean isRunning = false;
	private BufferStrategy bs;// render yaparken double buffurla canvas da display olay�n� y�netiyor
	private Graphics gra;// draw i�in

	private State gameState;
	private State MainMenuState;

	private KeyMngr kym;

	private Display display;
	private Thread thread;// Thread tipinde de�i�ken thread

	private void initial() throws IOException// because of imageloader throws �o exception
	{
		kym = new KeyMngr();
		display = new Display();// static yaparak t�m initializationdan kurtulduk.
		display.getFrame().addKeyListener(kym);
		Assets.init();
		gameState = new GameState(this);// polymorpho

		MainMenuState = new MainMenuState(this);
		State.setState(gameState);
      
	}

	private void update() {
		kym.update();// updates if pressed then chaanges that member of array to true,then in player
						// bike according to boolean it updates positon
		if (State.getState() != null)
			State.getState().update();

	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();// double or triple buffer
		if (bs == null) // d�ng�de bo� mu bakmak i�in
		{
			display.getCanvas().createBufferStrategy(2);// � go with 2 buffer after result check again,ger�ek zamanda
														// sorun ��karsa diye
			return;
		}
		gra = bs.getDrawGraphics();// returns graphics context for the drawing buffer,gra initializaion
		// 0,0 pixel at left most top corner y axis flipped
		// g�sterme ve do�ru kapan��
		gra.clearRect(0, 0, Display.getWidth(), Display.getHeight());
		// gra.setColor(Color.orange);
		// gra.fillRect(10,50,20,100);

		// gra.fillRect(x, y, width, height);

		/*
		 * gra.drawImage(Assets.a.get(1),0,y,null);//image observer null?
		 * gra.drawImage(Assets.a.get(0),300,100,null);
		 */
		if (State.getState() != null)
			State.getState().render(gra);

		bs.show();// makes visible //
		gra.dispose();// graphics garbage collector gibi
	}

	public void run() {
		try {
			initial();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ba�tan kurma k�sm�
		int fps = 60;// how many times we want to update and render
		double timePerUpdate = 1_000_000_000 / fps;// 1 billion nanosec in 1 sec ,maxx time for run update ad render
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();// jvm ba�lad���ndan beri current time return ediyor
		long timer = 0;

		int updts = 0;

		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			// start time - line79 exucition time /max time to update and add to delta
			timer += now - lastTime;

			lastTime = now;
			// yeni zaman bu birr dahaki exucutiona kadar.
			if (delta >= 1) {
				update();
				render();
				delta--;
				updts++; // update say�s�n� tutmak i�in
			}
			if (timer > 1_000_000_000) {
				System.out.println("Updates and frames  " + updts);
				updts = 0;
				timer = 0;
			}

		}
		stop();// synchronized method bizim yazd���m�za gidiyor.
	}

	// concurant proggramming
	public KeyMngr getKeyMngr() {
		return kym;
	}

	public synchronized void start() {
		if (isRunning)
			return;// methodu bitir zaten �al���yorsa bir daha threadi ba�lat�rsa hata verir.
					// kontrol mekanizmas�,return d�ng� ve methodlar� bitirir

		isRunning = true;
		thread = new Thread(this);// initialized
		thread.start();// iki thread �al���yor art�k ana program ve bu .run methodunu �al��t�r�yor.
		// ba�lam�� olan thread bir daha ba�lat�lamaz illegel thread exception throw
	}

	public synchronized void stop() {
		if (!isRunning)
			return;// zaten duruyorsa bir daha dur
		try {
			thread.join();
		}
		// if any thread interrupted by current thread ,bir daha da ba�layamaz.
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
