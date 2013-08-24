package joaogl.d4rk.ld27.graphics;

import static org.lwjgl.opengl.GL11.*;

import joaogl.d4rk.ld27.data.GameValues;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class Render {

	public Render() {

	}

	public static void render(float x, float y, float w, float h, Texture tex) {
		Color.white.bind();
		tex.bind();
		glBegin(GL11.GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(x, y);

		glTexCoord2f(1, 0);
		glVertex2f(x + w, y);

		glTexCoord2f(1, 1);
		glVertex2f(x + w, y + h);

		glTexCoord2f(0, 1);
		glVertex2f(x, y + h);
		glEnd();
	}

	public void setColor(int i) {
		int rr = (i & 0xff0000) >> 16;
		int gg = (i & 0xff00) >> 8;
		int bb = (i & 0xff);
		byte r = (byte) rr;
		byte g = (byte) gg;
		byte b = (byte) bb;
		glColor3ub(r, g, b);
	}

	public void setColor(float r, float g, float b) {
		glColor3f(r, g, b);
	}

	public void background() {
		glBegin(GL_QUADS);
		glVertex2f(0, 0);
		glVertex2f(GameValues.width, 0);
		glVertex2f(GameValues.width, GameValues.height);
		glVertex2f(0, GameValues.height);
		glEnd();
	}

}