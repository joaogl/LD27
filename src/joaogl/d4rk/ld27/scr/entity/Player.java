package joaogl.d4rk.ld27.scr.entity;

import org.lwjgl.input.Keyboard;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Render;
import joaogl.d4rk.ld27.graphics.Textures;
import joaogl.d4rk.ld27.scr.Level;

public class Player {

	static int px = 200, py = 150;

	public static void update() {
		int x = 0;
		int y = 0;
		if (Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W)) y = -GameValues.PLAYER_SPEED;
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S)) y = +GameValues.PLAYER_SPEED;
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A)) x = -GameValues.PLAYER_SPEED;
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D)) x = +GameValues.PLAYER_SPEED;
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (x != 0) {
				if (x > 0) x += 1;
				else x -= 1;
			}
			if (y != 0) {
				if (y > 0) y += 1;
				else y -= 1;
			}
		}
		if (x != 0 || y != 0) {
			if (x > 0 && (getR() + x) > GameValues.width) x = 0;
			else if (x < 0 && (getL() - x) < 0) x = 0;
			if (y > 0 && (getB() + y) > GameValues.height) y = 0;
			else if (y < 0 && (getT() - y) < 0) y = 0;
			if (x != 0) if (collisionx(x)) x = 0;
			if (y != 0) if (collisiony(y)) y = 0;
			move(x, y);
		}
	}

	private static boolean collisionx(int x) {
		int col = 0;
		if (x > 0) col = Level.getPixel(getR() + x, py);
		else if (x < 0) col = Level.getPixel(getL() - x, py);
		if (col != 99999999 && col != -27288) return false;
		return true;
	}

	private static boolean collisiony(int y) {
		int col = 0;
		if (y > 0) col = Level.getPixel(px, getB() + y);
		else col = Level.getPixel(px, getT() - y);
		if (col != 99999999 && col != -27288) return false;
		return true;
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

	public int getPlayerX() {
		return px;
	}

	public int getPlayerY() {
		return py;
	}

	public static int getR() {
		return (px + GameValues.PLAYER_SIZE);
	}

	public static int getL() {
		return (px - 3);
	}

	public static int getT() {
		return (py - 3);
	}

	public static int getB() {
		return ((py - 1) + GameValues.PLAYER_SIZE);
	}

	public void render() {
		Render.render(px, py, GameValues.PLAYER_SIZE, GameValues.PLAYER_SIZE, Textures.player);
	}

}