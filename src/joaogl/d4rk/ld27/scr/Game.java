package joaogl.d4rk.ld27.scr;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Render;
import joaogl.d4rk.ld27.scr.entity.Bot;
import joaogl.d4rk.ld27.scr.entity.Player;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class Game implements Runnable {

	public boolean running = false;
	Thread thread;
	Render render;
	int fps;
	int ups;
	boolean renderit = true;
	Player player = new Player();
	Bot bot = new Bot();
	Level level = new Level();

	public Game() {
		render = new Render();
	}

	private void init() {
		try {
			Display.setDisplayMode(new DisplayMode(GameValues.width, GameValues.height));
			Display.setTitle(GameValues.GAME_NAME);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		glMatrixMode(GL_PROJECTION_MATRIX);

		glEnable(GL_TEXTURE_2D);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		glEnable(GL_COLOR_MATERIAL);
		glEnable(GL11.GL_BLEND);
		glViewport(0, 0, GameValues.width, GameValues.height);
		glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		glLoadIdentity();
		glOrtho(0, GameValues.width, GameValues.height, 0, 0, 1.0f);

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

	private void update() {
		Player.update();
		Bot.update();
		Level.update();
	}

	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		render.setColor(0x77E1FF);
		render.background();
		level.render();
		player.render();
		bot.render();
		Display.update();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
