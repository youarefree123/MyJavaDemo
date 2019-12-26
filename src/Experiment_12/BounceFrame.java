package Experiment_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BounceFrame extends JFrame {
    private BounceComponent comp;
    public static final int DELAY = 5;
    private double allEn = 0;
    public JLabel n = new JLabel("小球能量为：");
    private JPanel buttonPanel;



    public BounceFrame()
    {
        comp = new BounceComponent();
        add(comp, BorderLayout.CENTER);
        comp.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                addBall((int)e.getPoint().getX(),(int)e.getPoint().getY());
            }
        });
        setButtonPanel(new JPanel());
        add(n,BorderLayout.NORTH);
        pack();//窗口自动适应大小，使窗口能正好显示里面所有的控件
    }


    public void addBall(int x,int y)
    {
        final Ball ball = new Ball(x,y);
        comp.add(ball);
        BallRun bu = new BallRun(ball);
        Thread t = new Thread(bu);
        t.start();
    }

    private class BallRun implements Runnable{
        private Ball ball;
        public BallRun(Ball ball){
            this.ball = ball;
        }
        @Override
        public void run() {
            try
            {
                while (true)
                {
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY);
                    n.setText("小球能量为：" + comp.getAllEn());
                }
            }
            catch (InterruptedException e)
            {
            }
        }
    }
    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

}

