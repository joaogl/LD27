package joaogl.d4rk.ld27.scr;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.opengl.Texture;

import joaogl.d4rk.ld27.graphics.Render;

public class Level {

	public static int[] pixels;
	private static int level = 0;
	static Texture texture;
	static int w, h;

	public static void update() {

	}

	public static void setLevel(int i, Texture tex, String path) {
		level = i;
		texture = tex;
		BufferedImage image = null;
		try {
			image = ImageIO.read(Level.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		w = image.getWidth();
		h = image.getHeight();
		pixels = new int[w * h];
		image.getRGB(0, 0, w, h, pixels, 0, w);
	}

	public static int getLevelID() {
		return level;
	}

	public static int getLevelWidth() {
		return w;
	}

	public static int getLevelHeight() {
		return h;
	}

	public static Texture getLevelTexture() {
		return texture;
	}

	public static int getPixel(int x, int y) {
		if ((x + y * w) > 0) if (pixels.length > (x + y * w)) return pixels[x + y * w];
		return 99999999;
	}

	public void render() {
		Render.render(0, 0, texture.getTextureWidth(), texture.getTextureHeight(), texture);
	}

}