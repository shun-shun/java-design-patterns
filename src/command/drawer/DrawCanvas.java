package command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import command.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {
	private Color color = Color.red;
	private int radiux = 6;
	private MacroCommand history;

	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width,height);
		setBackground(Color.white);
		this.history = history;
	}

	public void paint(Graphics g) {
		history.execute();
	}

	@Override
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radiux, y - radiux, radiux * 2, radiux * 2);
	}

}
