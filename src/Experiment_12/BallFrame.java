//package Experiment_12;
//
///**
// * 该类主要用于绘制GUI。
// * @author Hephaest
// * @version 2019/7/5
// * @since jdk_1.8.202
// */
//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.RenderingHints;
//import java.util.ArrayList;
//
//import javax.swing.JFrame;
//
//public class BallFrame extends JFrame {
//    private ArrayList<Ball> ball = new ArrayList<Ball>();
//    private Image img;
//    private Graphics2D graph;
//
//    /**
//     * BallFrame 类的构造函数。
//     */
//    public BallFrame()
//    {
//        super("BallGame");
//        setSize(600, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        setResizable(false);
//        setVisible(true);
//    }
//
//
//    //主函数。
//    public static void main(String[] args) {
//       // BallFrame.setLookAndFeel();
//        BallFrame bf = new BallFrame();
//        bf.UI();
//    }
//
//    /**
//     * 添加监听器。
//     */
//    public void UI() {
//        Listener lis = new Listener(this, ball);
//        this.addMouseListener(lis);
//        Thread current = new Thread(lis);
//        current.start();
//
//    }
//
//
//
//    /**
//     * 该方法是用于重绘不同区域的画布。
//     */
//    public void paint(Graphics g) {
//        img = this.createImage(this.getWidth(), this.getHeight());
//        graph = (Graphics2D)img.getGraphics();
//        for (int i = 0; i < ball.size(); i++) {
//            Ball myBall = ball.get(i);
//            myBall.drawBall(graph);
////            myBall.collision(ball);
//            myBall.moveBall(this);
//        }
//        g.drawImage(img, 0, -2, this);
//    }
//
//}