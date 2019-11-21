package Experiment_8;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyRect extends MyShape {

	public MyRect(int x1, int y1, int x2, int y2, Color color) {
		super(new MyPoint(x1, y1), new MyPoint(x2, y2), color);
	}

	public void Draw(Graphics2D g) {
		Rectangle2D.Double rect = new Rectangle2D.Double(getP1().getX(), getP1().getY(),
				getP2().getX() - getP1().getX(), getP2().getY() - getP1().getY());
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getColor());
		g2.fill(rect);
		g2.setColor(Color.BLACK);
		g2.draw(rect);
	}

	@Override
	public boolean IsContain(MyPoint p) {
		if (p.IsBig(getP2()) && p.IsSmall(getP1())) {
			return true;
		}
		return false;
	}

	

}