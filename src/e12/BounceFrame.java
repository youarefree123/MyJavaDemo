package e12;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BounceFrame extends JFrame{
    private BouncePanel mainPanel;
//    private JLabel energylabel;
    private final int STEP = 1000;
    private final int DLAY = 20;
    public BounceFrame() {
//        energylabel = new JLabel("0");
        JPanel labelpanel = new JPanel();
//        labelpanel.add(energylabel);

        JButton exitbtn = new JButton("exit");
        exitbtn.addActionListener(event->{
            System.exit(0);
        });
        JButton starbtn = new JButton("start");

//        btnpanel.add(starbtn);

        mainPanel = new BouncePanel();
        mainPanel.add(labelpanel);
        add(mainPanel, BorderLayout.CENTER);
        Thread t = new PaintThread();
        t.start();
    }

    class PaintThread extends Thread{
        @Override
        public void run() {
            // TODO Auto-generated method stub
            super.run();
            while (true) {
                mainPanel.repaint();
//                double energy = mainPanel.getTatolEnergy();
//                mainPanel.FixColor();
//                energylabel.setText(String.format("%.2f", energy));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        }
    }
}

