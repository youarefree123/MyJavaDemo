//package Experiment_12;
///**
// * 此类是用于监听 BallFrame GUI 的文字输入和按监听的。
// * 用户可以输入参数然后点击按钮"Play"或者在画板中指定区域单机鼠标生成小球。
// * @author Hephaest
// * @version 2019/7/5
// * @since jdk_1.8.202
// */
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.regex.Pattern;
//
//import javax.swing.*;
//
//public class Listener extends MouseAdapter implements Runnable {
//    /**
//     * 声明监听器里的所有变量。
//     * 需要注意何时更改 clearFlag 和 pauseFlag 的布尔值。
//     */
//    private BallFrame bf;
//    private Random rand = new Random();
//    private volatile boolean clearFlag = false, pauseFlag = false;
//    private ArrayList<Ball> ball;
//    Thread playing;
//
//    /**
//     * 监听器的构造函数。
//     * @param bf BallFrame 类的实例。
//     * @param ball 所有小球组成的列表。
//     */
//    public Listener(BallFrame bf, ArrayList ball) {
//        this.bf = bf;
//        this.ball = ball;
//    }
//
//    /**
//     * 每次点击小球时，只能直到生成小球的初始位置，但是它的速度分量都是随机数。
//     */
//    public void mousePressed(MouseEvent e) {
//        int x = e.getX();
//        int y = e.getY();
//
//        //int xPos, int yPos, int ySpeed, int mass, BallFrame bf
//        Ball newBall = new Ball(x, y, 50, 1,bf);
//        ball.add(newBall);
//    }
//
//    @Override
//    /**
//     * 该方法是 Runnable 的重写。
//     * 如果用户选择暂停的话，需要停止画板刷新和新的绘制。
//     */
//    public void run() {
//        while (!clearFlag) {
//            if(!pauseFlag)
//            {
//                bf.repaint();
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//}