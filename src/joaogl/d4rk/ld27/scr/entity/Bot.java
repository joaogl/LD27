package joaogl.d4rk.ld27.scr.entity;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Render;
import joaogl.d4rk.ld27.graphics.Textures;

public class Bot {

	static boolean dir = false;
	static int bx = 0, by = 200;

	public static void update() {
		move();
	}

	private static void move() {
		if (dir) bx += GameValues.BOT_SPEED;
		else bx -= GameValues.BOT_SPEED;
		if (bx < 0) dir = true;
		if (bx >= (GameValues.width - GameValues.PLAYER_SIZE)) dir = false;
	}

	public void render() {
		Render.render(bx, by, GameValues.PLAYER_SIZE, GameValues.PLAYER_SIZE, Textures.bot);
	}

}