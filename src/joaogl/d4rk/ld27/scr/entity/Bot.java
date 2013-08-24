package joaogl.d4rk.ld27.scr.entity;

import java.util.Random;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Render;
import joaogl.d4rk.ld27.graphics.Textures;
import joaogl.d4rk.ld27.scr.Level;

public class Bot {

	static boolean dir = false;
	static int bx = 0, by = 200;
	static int time = 0;
	static int x = 0;
	static int y = 0;
	
	public static void update() {
		Random rand = new Random();
		int dir = rand.nextInt(9);
		if (time == 0) {
			x = 0;
			y = 0;
			if (dir == 1) y = -GameValues.PLAYER_SPEED;
			else if (dir == 5) {
				x = +GameValues.PLAYER_SPEED;
				y = -GameValues.PLAYER_SPEED;
			} else if (dir == 2) x = +GameValues.PLAYER_SPEED;
			else if (dir == 6) {
				x = +GameValues.PLAYER_SPEED;
				y = +GameValues.PLAYER_SPEED;
			} else if (dir == 3) y = +GameValues.PLAYER_SPEED;
			else if (dir == 7) {
				x = -GameValues.PLAYER_SPEED;
				y = +GameValues.PLAYER_SPEED;
			} else if (dir == 4) x = -GameValues.PLAYER_SPEED;
			else if (dir == 8) {
				x = -GameValues.PLAYER_SPEED;
				y = -GameValues.PLAYER_SPEED;
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
		time++;
		if (time >= 20) time = 0;
	}

	private static boolean collisionx(int x) {
		int col = 0;
		if (x > 0) col = Level.getPixel(getR() + x, by);
		else if (x < 0) col = Level.getPixel(getL() - x, by);
		if (col != 99999999 && col != -27288) return false;
		return true;
	}

	private static boolean collisiony(int y) {
		int col = 0;
		if (y > 0) col = Level.getPixel(bx, getB() + y);
		else col = Level.getPixel(bx, getT() - y);
		if (col != 99999999 && col != -27288) return false;
		return true;
	}

	private static void move(int x, int y) {
		bx += x;
		by += y;
		if (x > 0) {
			if (((bx + GameValues.PLAYER_SIZE) + x) < GameValues.width) bx += x;
		} else if (x < 0) {
			if (((bx - x) > 0)) bx += x;
		}
		if (y > 0) {
			if (((by + GameValues.PLAYER_SIZE) + y) < GameValues.height) by += y;
		} else if (y < 0) {
			if ((by - y) > 0) by += y;
		}
	}

	public int getPlayerX() {
		return bx;
	}

	public int getPlayerY() {
		return by;
	}

	public static int getR() {
		return (bx + GameValues.PLAYER_SIZE);
	}

	public static int getL() {
		return (bx - 3);
	}

	public static int getT() {
		return (by - 3);
	}

	public static int getB() {
		return ((by - 1) + GameValues.PLAYER_SIZE);
	}

	public void render() {
		Render.render(bx, by, GameValues.PLAYER_SIZE, GameValues.PLAYER_SIZE, Textures.bot);
	}

}