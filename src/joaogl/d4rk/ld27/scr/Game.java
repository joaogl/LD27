package joaogl.d4rk.ld27.scr;

import java.awt.Color;

import joaogl.d4rk.ld27.data.GameValues;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
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
		glMatrixMode(GL_PROJECTION_MATRIX);
		glOrtho(0, width, height, 0, 0, 1.0f);
		glEnable(GL_TEXTURE_2D);
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
				System.out.println("FPS: " + fps + " UPS: " + ups);
			}
			check();
		}
		Display.destroy();
	}

	private void check() {
		if (Display.isCloseRequested()) running = false;
	}

	int px = 200, py = 150;
	int speed = 5;
	int bspeed = 10;
	boolean dir = false;
	int bx = 0, by = 200;

	private void update() {
		if (px <= width && px >= 0 && py <= height && py >= 0) {
			if (Keyboard.isKeyDown(Keyboard.KEY_UP)) py -= speed;
			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) py += speed;
			if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) px -= speed;
			if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) px += speed;
		}
		if (dir) bx += bspeed;
		else bx -= bspeed;
		if (bx < 0) dir = true;
		if (bx >= width) dir = false;
	}

	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		render.setColor(0xff00ff);
		render.tile(bx, by, 40);
		render.setColor(0xff0000);
		render.tile(px, py, 40);
		Display.update();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setSize(1280, 720);
		game.start();
	}
}
