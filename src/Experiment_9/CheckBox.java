package Experiment_9;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CheckBox {
    public static void main(String[] args)
    {
        JFrame frame=new CheckBoxFrame();
        frame.setTitle("这是一个复选框测试...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


class CheckBoxFrame extends JFrame
{
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE=24;

    public CheckBoxFrame()
    {
        label=new JLabel("The quick browm fox jump over the lazy dog(测试文本）");
        label.setFont(new Font("Serif",Font.BOLD,FONTSIZE));
        add(label,BorderLayout.CENTER);

        ActionListener listener=event-> {
            int mode=0;
            if(bold.isSelected())
                mode+=Font.BOLD;
            if(italic.isSelected())
                mode+=Font.ITALIC;
            label.setFont(new Font("Serif",mode,FONTSIZE));
        };

        JPanel buttonPanel=new JPanel();

        bold=new JCheckBox("BOLD");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic=new JCheckBox("ITALIC");
        italic.addActionListener(listener);
        italic.setSelected(true);
        buttonPanel.add(italic);

        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }
}
