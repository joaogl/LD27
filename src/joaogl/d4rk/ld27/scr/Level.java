package joaogl.d4rk.ld27.scr;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.graphics.Render;
import joaogl.d4rk.ld27.graphics.Textures;

public class Level {

	public static void update() {

	}

	public void render() {
		Render.render(0, 0, (GameValues.width * 2), (GameValues.height * 2), Textures.level1);
	}

}