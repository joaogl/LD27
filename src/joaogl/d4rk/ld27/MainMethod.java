package joaogl.d4rk.ld27;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainMethod {

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle(GameValues.GAME_NAME);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.frame.setMinimumSize(new Dimension(850, 600));
		game.frame.setMaximumSize(new Dimension(3000, 3000 / 16 * 9));
		game.start();
	}

}