package joaogl.d4rk.ld27.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import joaogl.d4rk.ld27.data.GameValues;

public class SpawnLevel extends Level {

	public static int slx;
	public static int sly;

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(new File("\\res\\" + path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			slx = w;
			sly = h;
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			System.out.println("Exception! Could not load level file!");
			e.printStackTrace();
		}
	}

	protected void generateLevel(int x, int y) {
	}

}