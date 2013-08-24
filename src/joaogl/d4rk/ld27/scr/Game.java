package joaogl.d4rk.ld27.scr;

import joaogl.d4rk.ld27.data.GameValues;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Game implements Runnable {

	public int width, height;
	public boolean running = false;
	Thread thread;
	Render render;
	int fps;
	int ups;

	public Game() {
		render = new Render();
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
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
		init();
		long lastTime = System.nanoTime();
		double ns = 1000000000.0 / 60.0;
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
			if (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				fps = frames;
				ups = updates;
				updates = 0;
				frames = 0;
			}
			check();
		}
		Display.destroy();
	}

	private void check() {
		if (Display.isCloseRequested()) running = false;
	}

	private void update() {
		System.out.println("FPS: " + fps + " UPS: " + ups);
	}

	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		// render.quad();
		render.triQuad();
		Display.update();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setSize(1280, 720);
		game.start();
	}
}
