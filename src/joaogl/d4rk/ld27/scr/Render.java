package joaogl.d4rk.ld27.scr;

import static org.lwjgl.opengl.GL11.*;

public class Render {

	public Render() {

	}

	public void tile(float x, float y, float size) {
		triQuad(x, y, size, size);
	}

	public void triQuad(float x, float y, float w, float h) {
		glBegin(GL_TRIANGLES);
		glVertex2f(x, y + h);
		glVertex2f(x, y);
		glVertex2f(x + w, y);

		glVertex2f(x, y + h);
		glVertex2f(x + w, y);
		glVertex2f(x + w, y + h);
		glEnd();
	}

	public void setColor(int i) {
		int r = (i & 0xff0000) >> 16;
		int g = (i & 0xff00) >> 8;
		int b = (i & 0xff) >> 16;
		glColor3f(r, g, b);
	}

}