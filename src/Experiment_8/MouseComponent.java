package Experiment_8;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class MouseComponent extends JComponent {
	private ArrayList<MyShape> squares;
	private MyShape current;
	private boolean isNewShape;
	private Color penColor;
	private String shapetype;
	private int oldx;
	private int oldy;

	public void paintComponent(Graphics g) {
		for (MyShape s : squares)
			s.Draw((Graphics2D) g);
	}

	public Color getPenColor() {
		return penColor;
	}

	public void setPenColor(Color penColor) {
		this.penColor = penColor;
	}

	public String getShapetype() {
		return shapetype;
	}

	public void setShapetype(String shapetype) {
		this.shapetype = shapetype;
	}

	public MouseComponent() {
		squares = new ArrayList<>();
		current = null;
		penColor = Color.BLACK;
		shapetype = "rect";
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandle());
	}

	public void add(MyPoint p) { // 识别shapetype，并将图形数据添加到ArrayList动态数组中
		int x = (int) p.getX();
		int y = (int) p.getY();
		if (shapetype.equals("rect"))
			current = new MyRect(x, y, x, y, penColor);
		if (shapetype.equals("elli"))
			current = new MyEllipse(x, y, x, y, penColor);
		squares.add(current);
		isNewShape = true;
	}

	public MyShape find(MyPoint p) // 寻找图形内是否已经有这个点，如果有返回这个图形，如果没有返回null
	{
		MyShape ret = null;
		for (MyShape r : squares) {
			if (r.IsContain(p))
				ret = r;
		}
		return ret;
	}

	public void remove(MyShape s) {
		if (s == null)
			return;
		if (s == current)
			current = null;
		squares.remove(s);
		repaint();
	}

	private class MouseHandler extends MouseAdapter {

		// @Override
		public void mouseClicked(MouseEvent e) {
			int cnum = e.getClickCount();
			int x = (int) e.getPoint().getX();
			int y = (int) e.getPoint().getY();
			current = find(new MyPoint(x, y));
			if (cnum >= 2) {
				remove(current);
			}
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			current = find(new MyPoint(x, y));
			if (current == null)
				add(new MyPoint(x, y));
			else {
				oldx = x;
				oldy = y;
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO 自动生成的方法存根
			isNewShape = false;
		}

	}

	private class MouseMotionHandle implements MouseMotionListener {

		public void mouseDragged(MouseEvent e) {
			// TODO 自动生成的方法存根
			int x = e.getX();
			int y = e.getY();
			if (current != null && !isNewShape) {

				current.Move(x - oldx, y - oldy);
				oldx = x;
				oldy = y;
			} else if (current != null && isNewShape) {

				current.update(new MyPoint(x, y));
				System.out.println("x坐标"+x+"y坐标"+y);
			}
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			int x = (int) e.getX();
			int y = (int) e.getY();
			if (find(new MyPoint(x, y)) == null) {
				setCursor(Cursor.getDefaultCursor());
			} else
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

	}

}
