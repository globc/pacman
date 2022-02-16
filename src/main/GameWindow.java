package main;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	
	private JButton clicker, quit;
	private int timesClicked;
	
	public GameWindow() {
		super("Game");
		this.timesClicked = 0;
		
		clicker = new JButton("Start");
		clicker.addActionListener((e) -> {this.timesClicked++; this.clicker.setText("Clicked: " + timesClicked); this.pack();}); // anonyme Klasse in GameWindow eingebettet.
		clicker.setFocusable(false); // KeyListener und ActionListener gleichzeitig
		this.add(clicker); // BorderLayout.CENTER
		
		quit = new JButton("Quit");
		quit.addActionListener((e) -> this.dispose());
		quit.setFocusable(false);
		this.add(quit, BorderLayout.SOUTH);
		
		this.addKeyListener(new GameInputHandler());
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private class GameInputHandler extends KeyAdapter{ // in GameWindow eingebettete Klasse
		
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
			
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
