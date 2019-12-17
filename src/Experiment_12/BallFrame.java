package Experiment_12;

/**
 * 该类主要用于绘制GUI。
 * @author Hephaest
 * @version 2019/7/5
 * @since jdk_1.8.202
 */
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class BallFrame extends JFrame {
    private ArrayList<Ball> ball = new ArrayList<Ball>();
    private Image img;
    private Graphics2D graph;

//    /**
//     * JPanel 用于一行一行的放置文本框和按钮
//     */
//    JPanel row1 = new JPanel();
//    JLabel mass = new JLabel("mass:", JLabel.RIGHT);
//    JTextField massText, xSpeedText, xPositionText, sizeText, ySpeedText, yPositionText;
//    JLabel xSpeed = new JLabel("xSpeed:", JLabel.RIGHT);
//    JLabel xPosition = new JLabel("xPosition:", JLabel.RIGHT);
//    JLabel size = new JLabel("size:", JLabel.RIGHT);
//    JLabel ySpeed = new JLabel("ySpeed:", JLabel.RIGHT);
//    JLabel yPosition = new JLabel("yPosition:", JLabel.RIGHT);
//
//    JPanel row2 = new JPanel();
//    JButton stop = new JButton("Stop");
//    JButton Continue = new JButton("Continue");
//    JButton clear = new JButton("Clear");
//    JButton play = new JButton("Play");
//    JButton reset = new JButton("Reset");

    /**
     * BallFrame 类的构造函数。
     */
    public BallFrame()
    {
        super("BallGame");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        setVisible(true);
    }


    //主函数。
    public static void main(String[] args) {
       // BallFrame.setLookAndFeel();
        BallFrame bf = new BallFrame();
        bf.UI();
    }

    /**
     * 添加监听器。
     */
    public void UI() {
        Listener lis = new Listener(this, ball);
        this.addMouseListener(lis);
        Thread current = new Thread(lis);
        current.start();

    }

    /**
     * 这种方法是为了确保跨操作系统能够显示窗口。
     */
//    private static void setLookAndFeel() {
//        try {
//            UIManager.setLookAndFeel(
//                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
//            );
//        } catch (Exception exc) {
//            // 忽略。
//        }
//    }

    /**
     * 该方法是用于重绘不同区域的画布。
     */
    public void paint(Graphics g) {
        img = this.createImage(this.getWidth(), this.getHeight());
        graph = (Graphics2D)img.getGraphics();
        //渲染使无锯齿。
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graph.setBackground(getBackground());
        //遍历更新每一个小球的运动情况。
        for (int i = 0; i < ball.size(); i++) {
            Ball myBall = ball.get(i);
            myBall.drawBall(graph);
            myBall.collision(ball);
            myBall.moveBall(this);
        }
        g.drawImage(img, 0, 150, this);
    }

}