package joaogl.d4rk.ld27.graphics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Textures {

	public static Texture loadTexture(String key, String extension) {
		try {
			return TextureLoader.getTexture(extension, new FileInputStream(new File("res/tex/" + key + "." + extension)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getPath(String key, String extension) {
		return ("/tex/" + key + "." + extension);
	}

	public static Texture bot = loadTexture("bot", "png");
	public static Texture player = loadTexture("player", "png");
	public static Texture level1 = loadTexture("level1", "png");

}