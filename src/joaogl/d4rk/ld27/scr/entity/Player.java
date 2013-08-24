package joaogl.d4rk.ld27.scr.entity;

import org.lwjgl.input.Keyboard;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Render;
import joaogl.d4rk.ld27.graphics.Textures;

public class Player {

	static int px = 200, py = 150;

	public static void update() {
		int x = 0;
		int y = 0;
		if (Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W)) y = -GameValues.PLAYER_SPEED;
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S)) y = +GameValues.PLAYER_SPEED;
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A)) x = -GameValues.PLAYER_SPEED;
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D)) x = +GameValues.PLAYER_SPEED;
		if (x != 0 || y != 0) move(x, y);
	}

	private static void move(int x, int y) {
		px += x;
		py += y;
		if (x > 0) {
			if (((px + GameValues.PLAYER_SIZE) + x) < GameValues.width) px += x;
		} else if (x < 0) {
			if (((px - x) > 0)) px += x;
		}
		if (y > 0) {
			if (((py + GameValues.PLAYER_SIZE) + y) < GameValues.height) py += y;
		} else if (y < 0) {
			if ((py - y) > 0) py += y;
		}
	}

	public void render() {
		Render.render(px, py, GameValues.PLAYER_SIZE, GameValues.PLAYER_SIZE, Textures.player);
	}

}