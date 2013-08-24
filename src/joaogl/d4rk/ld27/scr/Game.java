package joaogl.d4rk.ld27.scr;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION_MATRIX;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;

import java.awt.Font;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Render;
import joaogl.d4rk.ld27.graphics.RenderText;
import joaogl.d4rk.ld27.graphics.Textures;
import joaogl.d4rk.ld27.scr.entity.Bot;
import joaogl.d4rk.ld27.scr.entity.Player;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;

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
	TrueTypeFont font;

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
		Level.setLevel(1, Textures.level1, Textures.getPath("level1", "png"));
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
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
				System.out.println("FPS: " + fps + " UPS: " + ups);/*
																	 * System.out.println("Player coords: " + player.getPlayerX() + " | " + player.getPlayerY()); System.out.println("Top Left: " + player.getL() + ", " + player.getT()); System.out.println("Top Right: " + player.getR() + ", " + player.getT()); System.out.println("Bot Left: " + player.getL() + ", " + player.getB()); System.out.println("Bot Right: " + player.getR() + ", " + player.getB());
																	 */
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
		render.setColor(0x77E1FF);
		// font.drawString(100, 100, "FPS: " + fps + " UPS: " + ups);

		Display.update();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
