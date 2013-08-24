package joaogl.d4rk.ld27.scr;

import static org.lwjgl.opengl.GL11.*;

public class Render {

	public Render() {

	}

	public void quad() {
		glBegin(GL_QUADS);
		glVertex2f(10.0f, 40.0f);
		glVertex2f(10.0f, 10.0f);
		glVertex2f(40.0f, 10.0f);
		glVertex2f(40.0f, 40.0f);
		glEnd();
	}

	public void triQuad() {
		glBegin(GL_TRIANGLES);
		glVertex2f(10.0f, 40.0f);
		glVertex2f(10.0f, 10.0f);
		glVertex2f(40.0f, 40.0f);

		glVertex2f(10.0f, 40.0f);
		glVertex2f(40.0f, 10.0f);
		glVertex2f(40.0f, 40.0f);
		glEnd();
	}

}