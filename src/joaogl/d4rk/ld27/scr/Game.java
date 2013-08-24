package joaogl.d4rk.ld27.scr;

import joaogl.d4rk.ld27.data.GameValues;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Game implements Runnable {

	public int width, height;
	public boolean running = false;
	Thread thread;

	public Game() {
		init();
	}

	private void init() {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(GameValues.GAME_NAME);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public void run() {
		long lastTime = System.nanoTime();
		double ns = 10000000000.0 / 60.0;
		double delta = 0;
		long lastTimer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			check();
		}
	}

	private void check() {
		if (Display.isCloseRequested()) running = false;
	}

	private void update() {
		Display.update();
	}

	private void render() {

	}
}
