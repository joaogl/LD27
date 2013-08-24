package joaogl.d4rk.ld27.tiles;

import java.util.Random;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Screen;
import joaogl.d4rk.ld27.graphics.Sprite;

public class LavaTile extends Tile {
	static int anim = 0;
	static int s = 1;
	public static Sprite sprite;
	final Random random = new Random();
	public int x;
	public int y;

	public LavaTile(int x, int y, Sprite sprite) {
		super(sprite);
		this.x = x;
		this.y = y;
	}

	public void update() {
		anim += 1;
		if (anim % 48 == 0) s *= -1;
		if (s == -1) sprite = Sprite.Lava1;
		if (s == 1) sprite = Sprite.Lava2;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << GameValues.TILE_BIT, y << GameValues.TILE_BIT, sprite);
	}

	public boolean solid() {
		return true;
	}
}