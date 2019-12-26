package Experiment_9;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
;import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
/菜单画布
 */
public class MenuComponent extends JFrame {
    private JPanel mainPanel; //主面板
    private JPanel radioPanel;
    private ButtonGroup group;
    private JLabel label; //标签
    JCheckBox bold; //复选框
    JCheckBox italiic;
    JCheckBoxMenuItem itemBold;  //菜单复选框
    JCheckBoxMenuItem itemItalic;
    private JRadioButton smallbutton,mediumbutton,largebutton,exbutton;
    JSlider slider; //移动滑块
    private int fontSize = 36; //字体大小
    private int fontmode = 0; //字体模式
    private String fontname = "Serif"; //初始字体
//    private static final int DEFAULT_SIZE = 36;


    public MenuComponent() { //面板
        setSize(600, 200);
        mainPanel = new JPanel(new GridBagLayout()); //网格布局

        //添加显示文本的标签
        label = new JLabel("Hello",SwingConstants.LEFT);
        label.setFont(new Font(fontname,fontmode,fontSize));
        label.setPreferredSize(new Dimension(400,200)); //Dimension：封装单个对象中组件的宽度和高度
        mainPanel.add(label); //添加标签

        //添加文本域，用于改写标签内容
        JPanel textPanel = new JPanel();
        JTextField tf = new JTextField(16); //文本框
        JButton btf  = new JButton("确定"); //按钮
        textPanel.add(tf);
        textPanel.add(btf);
        mainPanel.add(textPanel); //添加文本域
        btf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(tf.getText()); //标签得到文本框的内容，并重置标签内容
            }
        });


        //添加复选框
        JPanel checkPanel = new JPanel();
        bold = new JCheckBox("Bold");
        italiic = new JCheckBox("Italic");
        checkPanel.add(bold);
        checkPanel.add(italiic);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fontmode = 0 ;
                itemBold.setSelected(bold.isSelected());
                itemItalic.setSelected(italiic.isSelected());
                if(bold.isSelected()) fontmode += Font.BOLD; //单击加粗
                if(italiic.isSelected()) fontmode += Font.ITALIC; //单击斜体
                label.setFont(new Font(fontname,fontmode,fontSize)); //修改字体
            }
        };
        bold.setSelected(true);
        bold.addActionListener(listener);
        italiic.addActionListener(listener);
        mainPanel.add(checkPanel);


        //添加复选框
        JComboBox<String> faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("Arial");
        faceCombo.addItem("Georgia");
        faceCombo.addItem("Abys");
        faceCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fontname = faceCombo.getItemAt(faceCombo.getSelectedIndex());
                label.setFont(new Font(fontname,fontmode,fontSize));
            }
        });
        mainPanel.add(faceCombo);



        //添加滑动条
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(5);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider sourse = (JSlider)changeEvent.getSource();
                fontSize = sourse.getValue();
                label.setFont(new Font(fontname,fontmode,fontSize));
            }
        });
        sliderPanel.add(slider);
        mainPanel.add(sliderPanel);
        add(mainPanel);


        //添加菜单
        JMenuBar menu = new JMenuBar();
        JMenu edit = new JMenu("编辑");

        //字体模式
        JMenu mode = new JMenu("字体模式");
        itemBold = new JCheckBoxMenuItem("Bold");
        itemItalic = new JCheckBoxMenuItem("Italic");
        ActionListener modelistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fontmode = 0;
                bold.setSelected(itemBold.isSelected());
                italiic.setSelected(itemItalic.isSelected());
                if(itemBold.isSelected()) fontmode += Font.BOLD;
                if(italiic.isSelected()) fontmode += Font.ITALIC;
                label.setFont(new Font(fontname,fontmode,fontSize));
            }
        };
        itemBold.addActionListener(modelistener);
        itemItalic.addActionListener(modelistener);
        itemBold.setSelected(bold.isSelected());
        itemItalic.setSelected(itemItalic.isSelected());
        mode.add(itemBold);
        mode.add(itemItalic);
        edit.add(mode);


        //字体大小
        JMenuItem bigger = new JMenuItem("Bigger");
        bigger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fontSize += 5;
                slider.setValue(fontSize);
                label.setFont(new Font(fontname,fontmode,fontSize));
            }
        });

        JMenuItem smaller = new JMenuItem("Smaller");
        smaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fontSize -= 5;
                if(fontSize <= 0) fontSize = 1;
                slider.setValue(fontSize);
                label.setFont(new Font(fontname,fontmode,fontSize));
            }
        });
        edit.add(bigger);
        edit.add(smaller);
        menu.add(edit);
        this.setJMenuBar(menu); //设置栏
    }
}
