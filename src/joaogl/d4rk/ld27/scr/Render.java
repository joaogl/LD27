package joaogl.d4rk.ld27.scr;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Render {

	public Render() {

	}

	public static Texture loadTexture(String key, String extension) {
		try {
			return TextureLoader.getTexture(extension, new FileInputStream(new File("res/tex/" + key + "." + extension)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void tile(float x, float y, float size, Texture texture) {
		triQuad(x, y, size, size, texture);
	}

	public void triQuad(float x, float y, float w, float h, Texture tex) {
		tex.bind();
		glPushMatrix();
		{
			glBegin(GL_TRIANGLES);
			glVertex2f(x, y + h);
			glVertex2f(x, y);
			glVertex2f(x + w, y);

			glVertex2f(x, y + h);
			glVertex2f(x + w, y);
			glVertex2f(x + w, y + h);
			glEnd();
		}
		glPopMatrix();
	}

	public void setColor(int i) {
		int rr = (i & 0xff0000) >> 16;
		int gg = (i & 0xff00) >> 8;
		int bb = (i & 0xff);
		glColor3f(rr, gg, bb);
	}

}