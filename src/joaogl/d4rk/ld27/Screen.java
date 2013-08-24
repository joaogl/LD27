package joaogl.d4rk.ld27;

public class Screen {

	private int width, height;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void clearScreen(int[] pixels) {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}
	
	public void render(int[] pixels){
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0xFFFFFFFF;		
	}

}