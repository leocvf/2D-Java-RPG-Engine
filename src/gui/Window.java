package gui;

import game.Game;
import game.GameLoop;

import javax.swing.JFrame;

import utilities.Keyboard;
import utilities.Mouse;

public class Window extends JFrame {
	private static RenderManager rm;
	private static GameLoop gameLoop;
	private static Game game;
	private static Keyboard k;
	private static Mouse m;

	public Window(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setResizable(true);
		setIgnoreRepaint(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIgnoreRepaint(true);
		k = new Keyboard();
		addKeyListener(k);
		setVisible(true);
		setResizable(false);
		rm = new RenderManager(this);
		addMouseListener(m);
	}

	public static void main(String[] args) {
		Window w = new Window("Game", 600, 600);
		game = new Game(rm, k, m);
		gameLoop = new GameLoop(game);
		m = new Mouse(game);
		while (true) {
			gameLoop.run();
			rm.run();
		}
	}
}