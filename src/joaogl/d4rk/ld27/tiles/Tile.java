package joaogl.d4rk.ld27.tiles;

import java.awt.Rectangle;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Screen;
import joaogl.d4rk.ld27.graphics.Sprite;

public class Tile {
	protected boolean solid;
	public int x, y;
	public Sprite sprite;
	public static final Tile[] tiles = new Tile[256];

	// Wood
	public static Tile Wood1 = new BasicTile(0, Sprite.Wood1);
	public static Tile Wood2 = new BasicTile(1, Sprite.Wood2);
	public static Tile Wood3 = new BasicTile(2, Sprite.Wood3);
	public static Tile Wood4 = new BasicTile(3, Sprite.Wood4);
	public static Tile Wood5 = new BasicTile(4, Sprite.Wood5);
	public static Tile Wood6 = new BasicTile(5, Sprite.Wood6);
	public static Tile Wood7 = new BasicTile(6, Sprite.Wood7);
	public static Tile Wood8 = new BasicTile(7, Sprite.Wood8);
	public static Tile Wood9 = new BasicTile(8, Sprite.Wood9);

	// Dirt
	public static Tile Grass1 = new BasicTile(9, Sprite.Grass1);
	public static Tile Grass2 = new BasicTile(10, Sprite.Grass2);
	public static Tile Grass3 = new BasicTile(11, Sprite.Grass3);
	public static Tile Dirt1 = new BasicTile(12, Sprite.Dirt1);
	public static Tile Dirt2 = new BasicTile(13, Sprite.Dirt2);
	public static Tile Dirt3 = new BasicTile(14, Sprite.Dirt3);
	public static Tile Sand1 = new BasicTile(15, Sprite.Sand1);
	public static Tile Sand2 = new BasicTile(16, Sprite.Sand2);
	public static Tile Sand3 = new BasicTile(17, Sprite.Sand3);

	// Stone
	public static Tile Stone1 = new BasicTile(18, Sprite.Stone1);
	public static Tile Stone2 = new BasicTile(19, Sprite.Stone2);
	public static Tile Stone3 = new BasicTile(20, Sprite.Stone3);
	public static Tile Stone4 = new BasicTile(21, Sprite.Stone4);
	public static Tile Stone5 = new BasicTile(22, Sprite.Stone5);
	public static Tile Stone6 = new BasicTile(23, Sprite.Stone6);
	public static Tile Stone7 = new BasicTile(24, Sprite.Stone7);
	public static Tile Stone8 = new BasicTile(25, Sprite.Stone8);
	public static Tile Stone9 = new BasicTile(26, Sprite.Stone9);
	public static Tile Stone10 = new BasicTile(27, Sprite.Stone10);
	public static Tile Stone11 = new BasicTile(28, Sprite.Stone11);
	public static Tile Stone12 = new BasicTile(29, Sprite.Stone12);
	public static Tile Stone13 = new BasicTile(30, Sprite.Stone13);
	public static Tile Stone14 = new BasicTile(31, Sprite.Stone14);
	public static Tile Stone15 = new BasicTile(32, Sprite.Stone15);
	public static Tile Stone16 = new BasicTile(33, Sprite.Stone16);

	// Stuff
	public static Tile Spawn = new BasicTile(34, Sprite.Spawn);
	public static Tile Teleport1 = new BasicTile(35, Sprite.Teleport1);
	public static Tile Dots = new BasicTile(36, Sprite.Dots);
	public static Tile VoidTile = new VoidTile(0, Sprite.VoidSprite);
	public static Tile Target = new BasicTile(37, Sprite.Target);
	public static Tile Steal = new BasicTile(38, Sprite.Steal);
	public static Tile Teleport2 = new BasicTile(39, Sprite.Teleport2);
	public static Tile Water = new WaterTile(Sprite.Water1);
	public static Tile Lava = new LavaTile(0, 0, Sprite.Lava1);

	// Transparent
	public static Tile Flower1 = new BasicTile(40, Sprite.Flower1);
	public static Tile Flower2 = new BasicTile(41, Sprite.Flower2);
	public static Tile Flower3 = new BasicTile(42, Sprite.Flower3);
	public static Tile Flower4 = new BasicTile(43, Sprite.Flower4);
	public static Tile Flower5 = new BasicTile(44, Sprite.Flower5);
	public static Tile Flower6 = new BasicTile(45, Sprite.Flower6);
	public static Tile Flower7 = new BasicTile(46, Sprite.Flower7);
	public static Tile Flower8 = new BasicTile(47, Sprite.Flower8);

	// Rocks
	public static Tile RockD = new SolidTile(0, Sprite.RockD);
	public static Tile RockU = new SolidTile(1, Sprite.RockU);
	public static Tile RockL = new SolidTile(2, Sprite.RockL);
	public static Tile RockR = new SolidTile(3, Sprite.RockR);
	public static Tile RockDR = new SolidTile(4, Sprite.RockDR);
	public static Tile RockDL = new SolidTile(5, Sprite.RockDL);
	public static Tile RockUL = new SolidTile(6, Sprite.RockUL);
	public static Tile RockUR = new SolidTile(7, Sprite.RockUR);
	public static Tile RockSDR = new SolidTile(8, Sprite.RockSDR);
	public static Tile RockMid = new SolidTile(9, Sprite.RockMid);
	public static Tile RockCR = new SolidTile(10, Sprite.RockCR);
	public static Tile RockCL = new SolidTile(11, Sprite.RockCL);
	public static Tile RockSDL = new SolidTile(12, Sprite.RockSDL);
	public static Tile RockSTR = new SolidTile(13, Sprite.RockSTR);
	public static Tile RockSTL = new SolidTile(14, Sprite.RockSTL);

	// Asphalt
	public static Tile Asphalt1 = new BasicTile(48, Sprite.Asphalt1);
	public static Tile Asphalt2 = new BasicTile(49, Sprite.Asphalt2);
	public static Tile Asphalt3 = new BasicTile(50, Sprite.Asphalt3);
	public static Tile AsphaltMiddle1 = new BasicTile(51, Sprite.AsphaltMiddle1);

	public static Tile CrossWalk1Up = new BasicTile(52, Sprite.Crosswalk1Up);
	public static Tile CrossWalk2Up = new BasicTile(53, Sprite.Crosswalk2Up);
	public static Tile CrossWalk3Up = new BasicTile(54, Sprite.Crosswalk3Up);
	public static Tile AsphaltMiddle2 = new BasicTile(55, Sprite.AsphaltMiddle2);

	public static Tile Trait1Up = new BasicTile(56, Sprite.Trait1Up);
	public static Tile Trait2Up = new BasicTile(57, Sprite.Trait2Up);
	public static Tile Trait3Up = new BasicTile(58, Sprite.Trait3Up);
	public static Tile AsphaltMiddle3 = new BasicTile(59, Sprite.AsphaltMiddle3);

	public static Tile CrossWalk1Side = new BasicTile(60, Sprite.CrossWalk1Side);
	public static Tile CrossWalk2Side = new BasicTile(61, Sprite.Crosswalk2Side);
	public static Tile CrossWalk3Side = new BasicTile(62, Sprite.Crosswalk3Side);

	public static Tile Trait1Side = new BasicTile(63, Sprite.Trait1Side);
	public static Tile Trait2Side = new BasicTile(64, Sprite.Trait2Side);
	public static Tile Trait3Side = new BasicTile(65, Sprite.Trait3Side);

	protected byte id;

	public Tile() {
	}

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public Tile(int id, Sprite sprite) {
		this.id = (byte) id;
		this.sprite = sprite;
		tiles[id] = this;
	}

	public byte getId() {
		return id;
	}

	public void render(int x, int y, Screen screen) {
	}

	public void update() {
		Water.update();
		Lava.update();
	}

	public boolean solid() {
		return false;
	}

	public boolean isSolid() {
		return solid;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, GameValues.TILE_SIZE, GameValues.TILE_SIZE);
	}
}