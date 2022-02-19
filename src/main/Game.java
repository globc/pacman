package main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class Game extends JFrame{
	
	private Player player;
	
	public Game() {
		super("Game");
		this.player = new Player(0, 0, Direction.UP);
		
		setupFrame();
		mapKeys();
		
	}
	
	public void printPlayerStats() {
		Vec2D coords = this.player.getCoords();
		System.out.println(coords.x + " | " + coords.y + " | " + this.player.getDir());
	}
	
	private void setupFrame() {
		this.add(new GameScreen());
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		this.setVisible(true);
	}
	
	private void mapKeys() {
		InputMap inputs = this.rootPane.getInputMap();
		ActionMap actions = this.rootPane.getActionMap();
		
		inputs.put(KeyStroke.getKeyStroke("ESCAPE"), "ESCAPE");
		actions.put("ESCAPE", new GameActions(GameActions.PAUSE));
		
		inputs.put(KeyStroke.getKeyStroke("W"), "W");
		actions.put("W", new GameActions(GameActions.MOVE_UP));
		
		inputs.put(KeyStroke.getKeyStroke("A"), "A");
		actions.put("A", new GameActions(GameActions.MOVE_LEFT));
		
		inputs.put(KeyStroke.getKeyStroke("S"), "S");
		actions.put("S", new GameActions(GameActions.MOVE_DOWN));
		
		inputs.put(KeyStroke.getKeyStroke("D"), "D");
		actions.put("D", new GameActions(GameActions.MOVE_RIGHT));
		
	}
	
	public class GameActions extends AbstractAction  {
		
		public static final int MOVE_UP = 0;
		public static final int MOVE_LEFT = 1;
		public static final int MOVE_DOWN = 2;
		public static final int MOVE_RIGHT = 3;
		
		public static final int PAUSE = -1;
		
		private int actionID;
		
		public GameActions (int actionID) {
			this.actionID = actionID;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			switch (this.actionID) {
			case PAUSE:
				dispose();
				new OptionsMenu();
				//TODO Save game
				break;
			case MOVE_UP:
				player.face(Direction.UP);
				player.move();
				break;
			case MOVE_RIGHT:
				player.face(Direction.RIGHT);
				player.move();
				break;
			case MOVE_DOWN:
				player.face(Direction.DOWN);
				player.move();
				break;
			case MOVE_LEFT:
				player.face(Direction.LEFT);
				player.move();
				break;
			default:
			}
			
			printPlayerStats();
			
		}
		
	}

}
