package joaogl.d4rk.ld27.graphics;

import java.util.ArrayList;
import java.util.List;

import com.game.engine.TimeManager;
import com.game.engine.data.GameValues;
import com.game.engine.data.TilesValues;
import com.game.scr.entity.Entity;
import com.game.scr.graphics.Screen;
import com.game.scr.graphics.Sprite;
import com.game.scr.level.tiles.LightTile;
import com.game.scr.level.tiles.Tile;
import com.game.scr.level.tiles.TorchTile;
import com.game.scr.level.tiles.LavaTile;
import com.game.scr.level.tiles.TreeTile;
import com.game.scr.level.tiles.TreeTopTile;

public class Level {

	public int width;
	protected int height;
	protected int[] tilesInt;
	int tick = 0;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Entity> entities = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<LightTile> lightTiles = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Tile> postRender = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Tile> treetops = new ArrayList();
	public int[] tiles;
	public static int spx = 0;
	public static int spy = 0;
	TimeManager time = new TimeManager();

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
	}

	protected void loadLevel(String path) {
	}

	public void tick() {
		this.tick += 1;
		if (this.tick % 1 == 0) time.time();
		for (int i = 0; i < this.entities.size(); i++)
			((Entity) this.entities.get(i)).update();
		Tile tile = new Tile();
		tile.update();
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		if (xScroll < 0) xScroll = 0;
		if (xScroll > ((width << GameValues.TILE_BIT) - screen.width)) xScroll = ((width << GameValues.TILE_BIT) - screen.width);
		if (yScroll < 0) yScroll = 0;
		if (yScroll > ((height << GameValues.TILE_BIT) - screen.height)) yScroll = ((height << GameValues.TILE_BIT) - screen.height);
		screen.setOffset(xScroll, yScroll);

		int x0 = xScroll >> GameValues.TILE_BIT;
		int x1 = (xScroll + screen.width + GameValues.TILE_SIZE_MASK) >> GameValues.TILE_BIT;
		int y0 = yScroll >> GameValues.TILE_BIT;
		int y1 = (yScroll + screen.height + GameValues.TILE_SIZE_MASK) >> GameValues.TILE_BIT;

		for (int y = y0; y < y1; y++)
			for (int x = x0; x < x1; x++)
				getTile(x, y).render(x, y, screen);

		for (int y = y0 - 3; y < y1 + 3; y++) {
			for (int x = x0 - 3; x < x1 + 3; x++) {
				Tile tile = getTile2(x, y);
				if ((tile instanceof TorchTile) || (tile instanceof LavaTile)) {
					this.lightTiles.add(new LightTile(x, y));
					if (tile instanceof TorchTile) this.postRender.add(new TorchTile(x, y, Sprite.Torch));
					else if (tile instanceof LavaTile) this.postRender.add(new LavaTile(x, y, Sprite.Torch));
				}
			}
		}
		for (int i = 0; i < this.lightTiles.size(); i++)
			((LightTile) this.lightTiles.get(i)).render(((LightTile) this.lightTiles.get(i)).x, ((LightTile) this.lightTiles.get(i)).y, screen, this);
		for (int i = 0; i < this.postRender.size(); i++)
			((Tile) this.postRender.get(i)).render(((Tile) this.postRender.get(i)).x, ((Tile) this.postRender.get(i)).y, screen);
		for (int i = 0; i < this.entities.size(); i++)
			((Entity) this.entities.get(i)).render(screen);
		for (int i = 0; i < this.treetops.size(); i++)
			((Tile) this.treetops.get(i)).render(((Tile) this.treetops.get(i)).x, ((Tile) this.treetops.get(i)).y, screen);
		this.lightTiles.clear();
		this.postRender.clear();
		this.treetops.clear();
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.VoidTile;
		int tilesMath = tiles[x + y * width];

		if (GameValues.random) return RandomMethod(tilesMath);
		if (!GameValues.random) return SpawnMethod(tilesMath);
		return Tile.VoidTile;
	}

	public Tile getTile2(int x, int y) {
		if ((x < 0) || (x >= this.width) || (y < 0) || (y >= this.height)) return Tile.VoidTile;
		if (this.tiles[(x + y * this.width)] == TilesValues.tiles[41]) return Tile.Torch;
		// if (this.tiles[(x + y * this.width)] == TilesValues.tiles[42]) return
		// Tile.Lava;
		return Tile.VoidTile;
	}

	public static Tile SpawnMethod(int tilesMath) {
		for (int i = 0; i < TilesValues.tiles.length; i++)
			if (tilesMath == TilesValues.tiles[i]) return TilesValues.resulttiles[(i + 1)];
		return Tile.VoidTile;
	}

	public static Tile RandomMethod(int tilesMath) {
		if (tilesMath >= 0 && tilesMath <= 47) return Tile.Grass1;
		if (tilesMath == 48) return Tile.Wood1;
		if (tilesMath == 49) return Tile.Flower1;
		return Tile.VoidTile;
	}

	public void add(Entity e) {
		this.entities.add(e);
		e.init(this);
	}

	public void add(Entity e, Level level) {
		this.entities.add(e);
		e.init(level);
	}

	public void remove(Entity e) {
		this.entities.remove(e);
	}

}