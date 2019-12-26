package Experiment_9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;

class Demo extends JFrame
{
    private JLabel label;
    private ButtonGroup group;
    private JCheckBox bold,italic;//复选框
    private JRadioButton smallbutton,mediumbutton,largebutton,exbutton;
    private JMenuBar menuBar = new JMenuBar();//JMenubar负责创建菜单条
    private JMenu size,jmode,font,menu;//菜单
    private JMenuItem serif,DialogInput,Monospaced,small,big,item1,item2;
    private JCheckBoxMenuItem checkBoxMenuItem,checkBoxMenuItem2;//复选框
    private JPopupMenu poppu;//弹出式菜单
    private JSlider slider;//滑动条
    // private ChangeListener listener;//拖动滑块改变其值的时候会激发ChangeEvent事件,监听器
    private JComboBox<String> faComboBox;//下拉菜单控件。它永远只能选中一个项目，然而比单选按钮节省空间
    int mode=0;  int size2=20;  String name="";
    JPanel buttonlable,buttoncheck,buttonradio,buttonfont,buttonslider;

    public Demo()
    {
        buttonlable = new JPanel();
        buttoncheck = new JPanel();
        buttonradio = new JPanel();
        buttonradio.setLayout(new GridLayout(1, 4));
        buttonfont = new JPanel();
        buttonslider = new JPanel();
        faComboBox = new JComboBox<>();
        faComboBox.addItem("Serif");
        faComboBox.addItem("DialogInput");
        faComboBox.addItem("Monospaced");
        facom facom=new facom();
        faComboBox.addActionListener(facom);
        buttonfont.add(faComboBox);

        group = new ButtonGroup();
        smallbutton=new JRadioButton("Small", false);
        mediumbutton=new JRadioButton("Medium", true);
        largebutton=new JRadioButton("Large", false);
        exbutton=new JRadioButton("Extra large", false);

        Border etched=BorderFactory.createEtchedBorder();
        Border title=BorderFactory.createTitledBorder(etched, "Font Size");
        group.add(smallbutton);group.add(mediumbutton);group.add(largebutton);group.add(exbutton);buttonradio.add(smallbutton);buttonradio.add(mediumbutton);buttonradio.add(largebutton);buttonradio.add(exbutton);buttonradio.setBorder(title);

        FS ra=new FS();
        smallbutton.addActionListener(ra);	mediumbutton.addActionListener(ra);
        largebutton.addActionListener(ra);	exbutton.addActionListener(ra);

        bold = new JCheckBox("Bold");
        italic = new JCheckBox("Italic");
        bold.setSelected(true);
        buttoncheck.add(bold);
        buttoncheck.add(italic);
        check ck=new check();
        bold.addActionListener(ck);
        italic.addActionListener(ck);

        //菜单项
        menu = new JMenu("Menu");
        jmode = new JMenu("mode");
        checkBoxMenuItem=new JCheckBoxMenuItem("bold");  checkBoxMenuItem2=new JCheckBoxMenuItem("italic");   checkBoxMenuItem.setSelected(true);
        checkbox cb=new checkbox();   checkBoxMenuItem.addActionListener(cb);   checkBoxMenuItem2.addActionListener(cb);
        jmode.add(checkBoxMenuItem);  jmode.add(checkBoxMenuItem2);

        font=new JMenu("font");
        serif = new JMenuItem("serif");			 DialogInput = new JMenuItem("Dia");		Monospaced = new JMenuItem("Mon");
        font.add(serif);   font.add(DialogInput);  font.add(Monospaced);

        size=new JMenu("Size");
        small = new JMenuItem("small-5",'S');  	 small.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        big = new JMenuItem("big+5",'B');			 big.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));
        size.add(big);    size.add(small);

        menuBar.add(menu);   menuBar.add(size);   menu.add(jmode);   menu.add(font);   //menuBar.add(font);  					 menuBar.add(size);
        setJMenuBar(menuBar);
        menu me=new menu();
        small.addActionListener(me);   big.addActionListener(me);
        serif.addActionListener(me);   DialogInput.addActionListener(me);   Monospaced.addActionListener(me);
        // 标签
        label = new JLabel("I'am a Label",JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, size2));
        buttonlable.add(label);
        //滑动条
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        ChangeListener listener = event -> {
            JSlider source = (JSlider) event.getSource();
            size2= source.getValue();
            label.setFont(new Font(name,mode,size2));
        };

        slider.addChangeListener(listener);
        buttonslider.add(slider);
        add(buttonlable);
        add(buttoncheck);
        add(buttonradio);
        add(buttonfont);
        add(buttonslider);
    }

    private class facom implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(e.getSource()==faComboBox)
            {
                name=faComboBox.getItemAt(faComboBox.getSelectedIndex());
            }

            label.setFont(new Font(name, mode, size2));

        }
    }
    //Font Size 监听
    private class FS implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if (smallbutton.isSelected()) size2=10;
            if (mediumbutton.isSelected()) size2=20;
            if (largebutton.isSelected()) size2=30;
            if (exbutton.isSelected()) size2=40;
            label.setFont(new Font(name, mode, size2));

        }
    }
    //菜单复选框监听
    private class checkbox implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            mode=0;
            // TODO Auto-generated method stub
            if (checkBoxMenuItem.isSelected()) {
                mode+=Font.BOLD;
                bold.setSelected(true);
            }
            else bold.setSelected(false);
            if (checkBoxMenuItem2.isSelected()) {
                mode+=Font.ITALIC;
                italic.setSelected(true);
            }
            else italic.setSelected(false);
            label.setFont(new Font(name, mode, size2));

        }

    }
    //复选框监听器
    private class check implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            mode=0;
            // TODO Auto-generated method stub
            if(bold.isSelected()) {
                mode+=Font.BOLD;
                checkBoxMenuItem.setSelected(true);
            }
            else checkBoxMenuItem.setSelected(false);
            if(italic.isSelected()) {
                mode+=Font.ITALIC;
                checkBoxMenuItem2.setSelected(true);
            }
            else checkBoxMenuItem2.setSelected(false);
            label.setFont(new Font(name, mode, size2));

        }
    }
    //
    private class menu implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource()==small) size2-=5;
            if (e.getSource()==big) size2+=5;
            if (e.getSource()==serif) name="Serif";
            if (e.getSource()==Monospaced) name="Monospaced";
            if (e.getSource()==DialogInput) name="DialogInupt";
            label.setFont(new Font(name, mode, size2));

        }
    }

    public static void main(String[] args)
    {
        JFrame jFrame = new Demo();
        jFrame.setLayout(new GridLayout(5, 1));
        jFrame.setSize(400, 300);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

}
