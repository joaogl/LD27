package joaogl.d4rk.ld27.tiles;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Screen;
import joaogl.d4rk.ld27.graphics.Sprite;

public class SolidTile extends Tile {

	public SolidTile(int id, Sprite sprite) {
		super(id, sprite);
		this.solid = true;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << GameValues.TILE_BIT, y << GameValues.TILE_BIT, this);
	}
}