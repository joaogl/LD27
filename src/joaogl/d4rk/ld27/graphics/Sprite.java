package joaogl.d4rk.ld27.graphics;

import joaogl.d4rk.ld27.data.GameValues;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	public static boolean set = false;

	public static Sprite[] player_forward = new Sprite[190];
	public static Sprite[] player_back = new Sprite[190];
	public static Sprite[] player_side = new Sprite[190];

	// Wood
	public static Sprite Wood1 = new Sprite(GameValues.TILE_SIZE, 0, 0, SpriteSheet.wood);
	public static Sprite Wood2 = new Sprite(GameValues.TILE_SIZE, 1, 0, SpriteSheet.wood);
	public static Sprite Wood3 = new Sprite(GameValues.TILE_SIZE, 2, 0, SpriteSheet.wood);

	public static Sprite Wood4 = new Sprite(GameValues.TILE_SIZE, 0, 1, SpriteSheet.wood);
	public static Sprite Wood5 = new Sprite(GameValues.TILE_SIZE, 1, 1, SpriteSheet.wood);
	public static Sprite Wood6 = new Sprite(GameValues.TILE_SIZE, 2, 1, SpriteSheet.wood);

	public static Sprite Wood7 = new Sprite(GameValues.TILE_SIZE, 0, 2, SpriteSheet.wood);
	public static Sprite Wood8 = new Sprite(GameValues.TILE_SIZE, 1, 2, SpriteSheet.wood);
	public static Sprite Wood9 = new Sprite(GameValues.TILE_SIZE, 2, 2, SpriteSheet.wood);

	// Dirt
	public static Sprite Dirt1 = new Sprite(GameValues.TILE_SIZE, 0, 0, SpriteSheet.dirt);
	public static Sprite Grass1 = new Sprite(GameValues.TILE_SIZE, 1, 0, SpriteSheet.dirt);
	public static Sprite Sand1 = new Sprite(GameValues.TILE_SIZE, 2, 0, SpriteSheet.dirt);

	public static Sprite Dirt2 = new Sprite(GameValues.TILE_SIZE, 0, 1, SpriteSheet.dirt);
	public static Sprite Grass2 = new Sprite(GameValues.TILE_SIZE, 1, 1, SpriteSheet.dirt);
	public static Sprite Sand2 = new Sprite(GameValues.TILE_SIZE, 2, 1, SpriteSheet.dirt);

	public static Sprite Dirt3 = new Sprite(GameValues.TILE_SIZE, 0, 2, SpriteSheet.dirt);
	public static Sprite Grass3 = new Sprite(GameValues.TILE_SIZE, 1, 2, SpriteSheet.dirt);
	public static Sprite Sand3 = new Sprite(GameValues.TILE_SIZE, 2, 2, SpriteSheet.dirt);

	// Stone
	public static Sprite Stone1 = new Sprite(GameValues.TILE_SIZE, 0, 0, SpriteSheet.stone);
	public static Sprite Stone2 = new Sprite(GameValues.TILE_SIZE, 1, 0, SpriteSheet.stone);
	public static Sprite Stone3 = new Sprite(GameValues.TILE_SIZE, 2, 0, SpriteSheet.stone);
	public static Sprite Stone4 = new Sprite(GameValues.TILE_SIZE, 3, 0, SpriteSheet.stone);

	public static Sprite Stone5 = new Sprite(GameValues.TILE_SIZE, 0, 1, SpriteSheet.stone);
	public static Sprite Stone6 = new Sprite(GameValues.TILE_SIZE, 1, 1, SpriteSheet.stone);
	public static Sprite Stone7 = new Sprite(GameValues.TILE_SIZE, 2, 1, SpriteSheet.stone);
	public static Sprite Stone8 = new Sprite(GameValues.TILE_SIZE, 3, 1, SpriteSheet.stone);

	public static Sprite Stone9 = new Sprite(GameValues.TILE_SIZE, 0, 2, SpriteSheet.stone);
	public static Sprite Stone10 = new Sprite(GameValues.TILE_SIZE, 1, 2, SpriteSheet.stone);
	public static Sprite Stone11 = new Sprite(GameValues.TILE_SIZE, 2, 2, SpriteSheet.stone);
	public static Sprite Stone12 = new Sprite(GameValues.TILE_SIZE, 3, 2, SpriteSheet.stone);

	public static Sprite Stone13 = new Sprite(GameValues.TILE_SIZE, 0, 3, SpriteSheet.stone);
	public static Sprite Stone14 = new Sprite(GameValues.TILE_SIZE, 1, 3, SpriteSheet.stone);
	public static Sprite Stone15 = new Sprite(GameValues.TILE_SIZE, 2, 3, SpriteSheet.stone);
	public static Sprite Stone16 = new Sprite(GameValues.TILE_SIZE, 3, 3, SpriteSheet.stone);

	// Stuff
	public static Sprite Spawn = new Sprite(GameValues.TILE_SIZE, 0, 0, SpriteSheet.stuff);
	public static Sprite Teleport1 = new Sprite(GameValues.TILE_SIZE, 1, 0, SpriteSheet.stuff);
	public static Sprite Dots = new Sprite(GameValues.TILE_SIZE, 2, 0, SpriteSheet.stuff);

	public static Sprite Target = new Sprite(GameValues.TILE_SIZE, 0, 1, SpriteSheet.stuff);
	public static Sprite Steal = new Sprite(GameValues.TILE_SIZE, 1, 1, SpriteSheet.stuff);
	public static Sprite Teleport2 = new Sprite(GameValues.TILE_SIZE, 2, 1, SpriteSheet.stuff);

	public static Sprite Water1 = new Sprite(GameValues.TILE_SIZE, 0, 2, SpriteSheet.stuff);
	public static Sprite Water2 = new Sprite(GameValues.TILE_SIZE, 1, 2, SpriteSheet.stuff);
	public static Sprite Water3 = new Sprite(GameValues.TILE_SIZE, 2, 2, SpriteSheet.stuff);

	public static Sprite Lava1 = new Sprite(GameValues.TILE_SIZE, 0, 3, SpriteSheet.stuff);
	public static Sprite Lava2 = new Sprite(GameValues.TILE_SIZE, 1, 3, SpriteSheet.stuff);
	public static Sprite Lava3 = new Sprite(GameValues.TILE_SIZE, 2, 3, SpriteSheet.stuff);

	// ---- VOID TILE ----//
	public static Sprite VoidSprite = new Sprite(GameValues.TILE_SIZE, 3, 0, SpriteSheet.stuff);

	// Transparent
	public static Sprite Flower1 = new Sprite(GameValues.TILE_SIZE, 0, 0, SpriteSheet.transperent);
	public static Sprite Flower2 = new Sprite(GameValues.TILE_SIZE, 1, 0, SpriteSheet.transperent);
	public static Sprite Flower3 = new Sprite(GameValues.TILE_SIZE, 2, 0, SpriteSheet.transperent);

	public static Sprite Flower4 = new Sprite(GameValues.TILE_SIZE, 0, 1, SpriteSheet.transperent);
	public static Sprite Flower5 = new Sprite(GameValues.TILE_SIZE, 1, 1, SpriteSheet.transperent);
	public static Sprite Flower6 = new Sprite(GameValues.TILE_SIZE, 2, 1, SpriteSheet.transperent);

	public static Sprite Flower7 = new Sprite(GameValues.TILE_SIZE, 0, 2, SpriteSheet.transperent);
	public static Sprite Flower8 = new Sprite(GameValues.TILE_SIZE, 1, 2, SpriteSheet.transperent);
	public static Sprite Torch = new Sprite(GameValues.TILE_SIZE, 2, 2, SpriteSheet.transperent);

	// Rocks
	public static Sprite RockD = new Sprite(GameValues.TILE_SIZE, 0, 0, SpriteSheet.rocks);
	public static Sprite RockU = new Sprite(GameValues.TILE_SIZE, 1, 0, SpriteSheet.rocks);
	public static Sprite RockL = new Sprite(GameValues.TILE_SIZE, 2, 0, SpriteSheet.rocks);
	public static Sprite RockR = new Sprite(GameValues.TILE_SIZE, 3, 0, SpriteSheet.rocks);

	public static Sprite RockDR = new Sprite(GameValues.TILE_SIZE, 0, 1, SpriteSheet.rocks);
	public static Sprite RockDL = new Sprite(GameValues.TILE_SIZE, 1, 1, SpriteSheet.rocks);
	public static Sprite RockUL = new Sprite(GameValues.TILE_SIZE, 2, 1, SpriteSheet.rocks);
	public static Sprite RockUR = new Sprite(GameValues.TILE_SIZE, 3, 1, SpriteSheet.rocks);

	public static Sprite RockSDR = new Sprite(GameValues.TILE_SIZE, 0, 2, SpriteSheet.rocks);
	public static Sprite RockMid = new Sprite(GameValues.TILE_SIZE, 1, 2, SpriteSheet.rocks);
	public static Sprite RockCR = new Sprite(GameValues.TILE_SIZE, 2, 2, SpriteSheet.rocks);
	public static Sprite RockCL = new Sprite(GameValues.TILE_SIZE, 3, 2, SpriteSheet.rocks);

	public static Sprite RockSDL = new Sprite(GameValues.TILE_SIZE, 0, 3, SpriteSheet.rocks);
	public static Sprite RockSTR = new Sprite(GameValues.TILE_SIZE, 1, 3, SpriteSheet.rocks);
	public static Sprite RockSTL = new Sprite(GameValues.TILE_SIZE, 2, 3, SpriteSheet.rocks);

	// Asphalt
	public static Sprite Asphalt1 = new Sprite(GameValues.TILE_SIZE, 0, 0, SpriteSheet.asphalt);
	public static Sprite Asphalt2 = new Sprite(GameValues.TILE_SIZE, 1, 0, SpriteSheet.asphalt);
	public static Sprite Asphalt3 = new Sprite(GameValues.TILE_SIZE, 2, 0, SpriteSheet.asphalt);
	public static Sprite AsphaltMiddle1 = new Sprite(GameValues.TILE_SIZE, 3, 0, SpriteSheet.asphalt);

	public static Sprite CrossWalk1Side = new Sprite(GameValues.TILE_SIZE, 0, 1, SpriteSheet.asphalt);
	public static Sprite Crosswalk2Side = new Sprite(GameValues.TILE_SIZE, 1, 1, SpriteSheet.asphalt);
	public static Sprite Crosswalk3Side = new Sprite(GameValues.TILE_SIZE, 2, 1, SpriteSheet.asphalt);
	public static Sprite AsphaltMiddle2 = new Sprite(GameValues.TILE_SIZE, 3, 1, SpriteSheet.asphalt);

	public static Sprite Trait1Side = new Sprite(GameValues.TILE_SIZE, 0, 2, SpriteSheet.asphalt);
	public static Sprite Trait2Side = new Sprite(GameValues.TILE_SIZE, 1, 2, SpriteSheet.asphalt);
	public static Sprite Trait3Side = new Sprite(GameValues.TILE_SIZE, 2, 2, SpriteSheet.asphalt);
	public static Sprite AsphaltMiddle3 = new Sprite(GameValues.TILE_SIZE, 3, 2, SpriteSheet.asphalt);

	public static Sprite Trait1Up = new Sprite(GameValues.TILE_SIZE, 0, 3, SpriteSheet.asphalt);
	public static Sprite Trait2Up = new Sprite(GameValues.TILE_SIZE, 1, 3, SpriteSheet.asphalt);
	public static Sprite Trait3Up = new Sprite(GameValues.TILE_SIZE, 2, 3, SpriteSheet.asphalt);

	public static Sprite Crosswalk1Up = new Sprite(GameValues.TILE_SIZE, 0, 4, SpriteSheet.asphalt);
	public static Sprite Crosswalk2Up = new Sprite(GameValues.TILE_SIZE, 1, 4, SpriteSheet.asphalt);
	public static Sprite Crosswalk3Up = new Sprite(GameValues.TILE_SIZE, 2, 4, SpriteSheet.asphalt);

	public static void setupPlayerSprite() {
		// int i = 0;
		set = true;
		player_forward[0] = new Sprite(GameValues.PLAYER_SIZE, 0, 0, SpriteSheet.player);
		player_forward[1] = new Sprite(GameValues.PLAYER_SIZE, 1, 0, SpriteSheet.player);
		player_forward[2] = new Sprite(GameValues.PLAYER_SIZE, 2, 0, SpriteSheet.player);

		player_side[0] = new Sprite(GameValues.PLAYER_SIZE, 0, 1, SpriteSheet.player);
		player_side[1] = new Sprite(GameValues.PLAYER_SIZE, 1, 1, SpriteSheet.player);
		player_side[2] = new Sprite(GameValues.PLAYER_SIZE, 2, 1, SpriteSheet.player);

		player_back[0] = new Sprite(GameValues.PLAYER_SIZE, 0, 2, SpriteSheet.player);
		player_back[1] = new Sprite(GameValues.PLAYER_SIZE, 1, 2, SpriteSheet.player);
		player_back[2] = new Sprite(GameValues.PLAYER_SIZE, 2, 2, SpriteSheet.player);
		/*
		 * while (i < GameValues.PLAYER_AMMOUNT) { for (int y = 0; y < 3; y++) { for (int x = 0; x < 3; x++) { if (y == 0) player_forward[i] = new Sprite(GameValues.PLAYER_SIZE, x, y, SpriteSheet.player); else player_forward[i] = new Sprite(GameValues.PLAYER_SIZE, x, (y + 3), SpriteSheet.player); if (y == 0) player_side[i] = new Sprite(GameValues.PLAYER_SIZE, x, y + 1, SpriteSheet.player); else player_side[i] = new Sprite(GameValues.PLAYER_SIZE, x, ((y + 1) + 3), SpriteSheet.player); if (y == 0) player_back[i] = new Sprite(GameValues.PLAYER_SIZE, x, y + 2, SpriteSheet.player); else player_back[i] = new Sprite(GameValues.PLAYER_SIZE, x, ((y + 2) + 3), SpriteSheet.player); System.out.println(i + ": " + x + ", " + y); i++; } } }
		 */
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++)
			pixels[i] = colour;

	}

	private void load() {
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++)
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
	}
}