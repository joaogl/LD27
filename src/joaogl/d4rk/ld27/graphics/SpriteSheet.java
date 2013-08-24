package joaogl.d4rk.ld27.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import joaogl.d4rk.ld27.data.GameValues;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;

	public static SpriteSheet wood = new SpriteSheet("/textures/sheets/Tile/Wood.png", 192);
	public static SpriteSheet dirt = new SpriteSheet("/textures/sheets/Tile/Dirt.png", 192);
	public static SpriteSheet stone = new SpriteSheet("/textures/sheets/Tile/Stone.png", 256);
	public static SpriteSheet stuff = new SpriteSheet("/textures/sheets/Tile/Stuff.png", 256);
	public static SpriteSheet transperent = new SpriteSheet("/textures/sheets/Tile/Transperent.png", 192);
	public static SpriteSheet rocks = new SpriteSheet("/textures/sheets/Tile/Rocks.png", 256);
	public static SpriteSheet asphalt = new SpriteSheet("/textures/sheets/Tile/Asphalt.png", 320);

	public static SpriteSheet player = new SpriteSheet("/textures/sheets/Player/PlayerSheet.png", 192);

	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(new File("\\res\\" + path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}