package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class Game extends JFrame{
	
	private JButton clicker, quit;
	private int timesClicked;
	
	private Player player;
	
	public Game() {
		super("Game");
		this.timesClicked = 0;
		this.player = new Player(0, 0, Direction.UP);
		
		clicker = new JButton("Start");
		clicker.addActionListener((e) -> {this.timesClicked++; this.clicker.setText("Clicked: " + timesClicked); this.pack();}); // anonyme Klasse in GameWindow eingebettet.
		clicker.setFocusable(false); // KeyListener und ActionListener gleichzeitig
		clicker.setToolTipText("Click!");
		// this.add(clicker); // BorderLayout.CENTER
		
		quit = new JButton("Quit");
		quit.addActionListener((e) -> this.dispose());
		quit.setFocusable(false);
		quit.setToolTipText("Quit's the game");
		// this.add(quit, BorderLayout.SOUTH);
		
		this.add(new GameScreen());
		
		this.addKeyListener(new GameInputHandler());
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void printPlayerStats() {
		Vec2D coords = this.player.getCoords();
		System.out.println(coords.x + " | " + coords.y + " | " + this.player.getDir());
	}
	
	private class GameInputHandler extends KeyAdapter{ // in GameWindow eingebettete Klasse
		
		// keyTyped keine ActionKeys (Escape, Enter,..)
		
		public void keyPressed(KeyEvent event) {
			switch (event.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				dispose();
				break;
			case KeyEvent.VK_W:
				player.face(Direction.UP);
				player.move();
				break;
			case KeyEvent.VK_S:
				player.face(Direction.DOWN);
				player.move();
				break;
			case KeyEvent.VK_D:
				player.face(Direction.RIGHT);
				player.move();
				break;
			case KeyEvent.VK_A:
				player.face(Direction.LEFT);
				player.move();
				break;
			default:
			}
			
			printPlayerStats();
		}
		
		public void keyReleased(KeyEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				timesClicked++;
				clicker.setText("Clicked: " + timesClicked);
				pack();
			}
		}

	}

}
