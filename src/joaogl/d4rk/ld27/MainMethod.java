package joaogl.d4rk.ld27;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainMethod {

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(GameValues.GAME_NAME);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.frame.setMinimumSize(new Dimension(600, 300));
		game.frame.setMaximumSize(new Dimension(1200, 1200 / 16 * 9));
		game.frame.setTitle(GameValues.GAME_NAME);
		game.start();
	}

}