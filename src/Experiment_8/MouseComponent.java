package Experiment_8;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

public class MouseComponent extends JComponent { //鼠标组件类
	private ArrayList<MyShape> squares;
	private MyShape current; //当前图形
	private boolean isNewShape; //是否是新的图形
	private Color penColor; //新图形的颜色
	private String shapetype; //图形类型
	private int oldx;  //原来图形的坐标
	private int oldy;


	public MouseComponent() { //构造函数
		squares = new ArrayList<>();
		current = null;
		penColor = Color.BLUE;  //默认初始颜色为蓝色
		shapetype = "rectangle"; //默认初始形状画长方形
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //重写鼠标双击删除
				int cnum = e.getClickCount();  //获取与此事件关联的鼠标单击次数
				int x = (int) e.getPoint().getX(); //得到坐标
				int y = (int) e.getPoint().getY();
				current = find(new MyPoint(x, y)); //创建图形对象
				if (cnum >= 2) { //如果点击数大于等于三，删除改图形
					remove(current);
				}
				repaint(); //重新绘制
			}
			@Override
			public void mousePressed(MouseEvent e) { //重写鼠标按压事件，如果没有图形就创建一个新的图形
				int x = e.getX();
				int y = e.getY();
				current = find(new MyPoint(x, y)); //获取一个图形对象，没有返回一个null
				if (current == null)
					add(new MyPoint(x, y));  //如果是空对象的话，创建一个新的图形对象
				else {
					oldx = x; //否则得到鼠标的位置
					oldy = y;
				}
			}
			@Override
			public void mouseReleased(MouseEvent arg0) { //按下鼠标并释放
				isNewShape = false;
				repaint();
			}
		}); //鼠标的监听器

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { //拖拽方法
				int x = e.getX();
				int y = e.getY();
				if(isNewShape && current != null)//如果当前图形对象非空并且是新图形对象
					current.update(new MyPoint(x,y));
				else if (current != null && !isNewShape) { //如果当前图形对象非空并且不是新图形对象
//				else if (!isNewShape){
					int dx = x-oldx;
					int dy = y - oldy;
					oldx = x;
					oldy = y;
					current.Move(dx, dy); //拖拽图形对象
				}
				repaint(); //重新绘制
			}

			@Override
			public void mouseMoved(MouseEvent e) { //鼠标移动方法
				int x = (int) e.getX();
				int y = (int) e.getY();
				if (find(new MyPoint(x, y)) == null) {
					setCursor(Cursor.getDefaultCursor()); //设置系统默认光标
				} else
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//返回一个具有指定光标类型。
			}
		}); //鼠标事件监听器
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

	public void add(MyPoint p) { // 识别图象类型shapetype，并将图形数据添加到ArrayList中
		int x = (int) p.getX();
		int y = (int) p.getY();
		if (shapetype.equals("rectangle"))
			current = new MyRectangle(x, y, x, y, penColor);
		if (shapetype.equals("ellipse"))
			current = new MyEllipse(x, y, x, y, penColor);
		squares.add(current);
		isNewShape = true;
	}

	public MyShape find(MyPoint p) // 寻找所有图形中是否已经有某个图形包含这个点，如果有返回这个图形，如果没有返回null
		{
			MyShape ret = null;
			for (MyShape r : squares) {
				if (r.IsContain(p))
					ret = r;
			}
			return ret;
	}

	public void remove(MyShape s) {  //删除图象
		if (s == null)
			return;
		if (s == current)
			current = null;
		squares.remove(s);
		repaint();
	}

	public void paintComponent(Graphics g) { //画出图形
		for (MyShape s : squares)
			s.Draw((Graphics2D) g);
	}

}
