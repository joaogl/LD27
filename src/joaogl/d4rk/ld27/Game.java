package joaogl.d4rk.ld27;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	boolean running = false;
	Thread thread;
	int fps = 0;
	int ups = 0;
	public JFrame frame;

	public Game() {
		Dimension size = new Dimension(GameValues.width, GameValues.height);
		setPreferredSize(size);
		frame = new JFrame();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		if (!this.running) return;
		this.running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		long timer2 = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		double delta2 = 0;
		int frames = 0;
		int ticks = 0;
		if (running) requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				Runtime runtime = Runtime.getRuntime();
				frame.setTitle(GameValues.GAME_NAME + " || Ram: " + (runtime.totalMemory() - runtime.freeMemory()) / 1048576L + "/" + runtime.totalMemory() / 1048576L + " MB");
				fps = frames;
				ups = ticks;
				update();
				ticks = 0;
				frames = 0;
			}
		}
	}

	public void update() {
		System.out.println(fps + " : " + ups);
	}

	public void tick() {

	}

	public void render() {

	}

}
