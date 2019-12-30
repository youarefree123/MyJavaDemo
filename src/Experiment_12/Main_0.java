package Experiment_12;

import javax.swing.*;

/**
 * 实验十二：多线程
 */
public class Main_0 {
    public static void main(String[] args)
    {
        JFrame frame = new BounceFrame();
        frame.setTitle("BounceThread");
        frame.setBounds(200,200,800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
