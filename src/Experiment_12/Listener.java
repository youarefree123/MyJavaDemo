package Experiment_12;
/**
 * 此类是用于监听 BallFrame GUI 的文字输入和按监听的。
 * 用户可以输入参数然后点击按钮"Play"或者在画板中指定区域单机鼠标生成小球。
 * @author Hephaest
 * @version 2019/7/5
 * @since jdk_1.8.202
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.*;

public class Listener extends MouseAdapter implements ActionListener,Runnable {
    /**
     * 声明监听器里的所有变量。
     * 需要注意何时更改 clearFlag 和 pauseFlag 的布尔值。
     */
    private BallFrame bf;
    private Random rand = new Random();
    private volatile boolean clearFlag = false, pauseFlag = false;
    private ArrayList<Ball> ball;
    Thread playing;

    /**
     * 监听器的构造函数。
     * @param bf BallFrame 类的实例。
     * @param ball 所有小球组成的列表。
     */
    public Listener(BallFrame bf, ArrayList ball) {
        this.bf = bf;
        this.ball = ball;
    }

    /**
     * 每次点击小球时，只能直到生成小球的初始位置，但是它的速度分量都是随机数。
     */
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        Ball newBall = new Ball(x, y - 163, 50, (1 + rand.nextInt(9) * (Math.random() > 0.5 ? 1 : -1)),
                (1 + rand.nextInt(9) * (Math.random() > 0.5? 1 : -1)),
                new Color(rand.nextInt(255),rand.nextInt(255), rand.nextInt(255)),rand.nextInt(9) + 1, bf);
        ball.add(newBall);
    }

    @Override
    /**
     * 该方法是 Runnable 的重写。
     * 如果用户选择暂停的话，需要停止画板刷新和新的绘制。
     */
    public void run() {
        while (!clearFlag) {
            if(!pauseFlag)
            {
                bf.repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 该方法用来响应不同按钮的需求。
     */
    public void actionPerformed(ActionEvent event) {
       // String command = event.getActionCommand();
//        if (command.equals("Play")) {
//            if (checkValid(bf.massText.getText(), bf.sizeText.getText(), bf.xPositionText.getText(), bf.yPositionText.getText())) {
//                startPlaying();
//            } else {
//                JOptionPane.showMessageDialog(null, "Please enter correct numbers!");
//            }
//        }
//        if (command.equals("Stop")) {
//            stopPlaying();
//        }
//        if (command.equals("Reset")) {
//            setAllFields();
//        }
//        if (command.equals("Continue")) {
//            continuePlaying();
//        }
//        if (command.equals("Clear")) {
//            clearPlaying();
//        }
    }

    /**
     * 该方法用来响应 "Reset" 按钮。
     * 每个文本框都设置默认值。
     * 重置完后无法再点击 "Reset" 或 "Continue"。
     */
//    void setAllFields() {
//        bf.massText.setText("1");
//        bf.xSpeedText.setText("1");
//        bf.xPositionText.setText("0");
//        bf.sizeText.setText("50");
//        bf.ySpeedText.setText("1");
//        bf.yPositionText.setText("0");
//        bf.reset.setEnabled(false);
//        bf.play.setEnabled(true);
//        bf.Continue.setEnabled(false);
//        bf.clear.setEnabled(true);
//    }

    /**
     * 该方法用来响应 "Play" 按钮。
     * 需要创建一个新的进程并设置 clearFlag 为 false, 这样 run() 函数可以正常运行。
     * 运行完后无法再点击 "play" again 或 "Continue"。
     */
//    void startPlaying() {
//        playing = new Thread(this);
//        playing.start();
//        clearFlag = false;
//        bf.play.setEnabled(false);
//        bf.Continue.setEnabled(false);
//        bf.stop.setEnabled(true);
//        bf.reset.setEnabled(true);
//        bf.clear.setEnabled(true);
//        String xP = bf.xPositionText.getText();
//        int x = Integer.parseInt(xP);
//        String yP = bf.yPositionText.getText();
//        int y = Integer.parseInt(yP);
//        String Size = bf.sizeText.getText();
//        int size = Integer.parseInt(Size);
//        String Xspeed = bf.xSpeedText.getText();
//        int xspeed = Integer.parseInt(Xspeed);
//        String Yspeed = bf.ySpeedText.getText();
//        int yspeed = Integer.parseInt(Yspeed);
//        String Mass = bf.massText.getText();
//        int mass = Integer.parseInt(Mass);
//        Ball myball = new Ball(x, y, size, xspeed,yspeed,
//                new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), mass, bf);
//        ball.add(myball);
//    }

    /**
     * 该方法用来响应 "Stop" 按钮。
     * 这个不需要重新绘制。
     * 用户无法再点击 "Stop" 按钮。
     */
//    void stopPlaying() {
//        bf.stop.setEnabled(false);
//        bf.play.setEnabled(true);
//        bf.reset.setEnabled(true);
//        bf.Continue.setEnabled(true);
//        bf.clear.setEnabled(true);
//        pauseFlag=true;
//    }

    /**
     * 该方法用来响应 "Continue" 按钮。
     * 需要设置 pauseFlag 的值用来一遍又一遍地重绘窗口。
     * 需要记住线程 "Playing" 仍在工作!
     * 用户无法再点击 "Continue" 按钮。
     */
//    void continuePlaying()
//    {
//        bf.stop.setEnabled(true);
//        bf.play.setEnabled(true);
//        bf.reset.setEnabled(true);
//        bf.Continue.setEnabled(false);
//        bf.clear.setEnabled(true);
//        pauseFlag = false;
//    }

    /**
     * 该方法用来响应 "Clear" 按钮。
     * 通过将线程声明为null来减少CPU的浪费。
     * 需要清空所有小球并重新绘制。
     * 用户无法再点击 "Clear" 或 "Stop" 或 "Continue" 按钮。
     */
//    void clearPlaying()
//    {
//        bf.clear.setEnabled(false);
//        bf.stop.setEnabled(false);
//        bf.play.setEnabled(true);
//        bf.reset.setEnabled(true);
//        bf.Continue.setEnabled(false);
//        playing = null;
//        clearFlag = true;
//        ball.clear();
//        bf.repaint();
//    }

    /**
     * 核查用户在文本框里的输入是否正确。
     * @param mass 小球的质量。
     * @param size 小球的直径。
     * @param xPos 小球在X轴的位置。
     * @param yPos 小球在Y轴的位置。
     * @return 返回核验结果。
     */
    private boolean checkValid(String mass, String size, String xPos, String yPos)
    {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (!pattern.matcher(mass).matches() || !pattern.matcher(size).matches() || !pattern.matcher(xPos).matches() || !pattern.matcher(yPos).matches())
            return false;
        else if (Integer.parseInt(mass) <= 0 || Integer.parseInt(size) <= 0 || Integer.parseInt(xPos) < 0 || Integer.parseInt(yPos) < 0)
            return false;
        else
            return true;
    }
}