package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameScreen extends Canvas{

	public GameScreen() {
		this.setBackground(Color.BLACK);
		this.setSize(new Dimension(1280, 720));
		this.setFocusable(false); // Bugfix: Keine Eingabeerkennung nach Fenster-Wechsel
	}
	
	@Override
	public void paint(Graphics g) {
	}
	
	@Override
	public void update(Graphics g) {
	}
	
}
