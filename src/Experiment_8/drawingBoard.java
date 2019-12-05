package Experiment_8;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class drawingBoard extends MouseComponent{
    private String path;
    public drawingBoard(String path) {
        super();
        this.path = path;
    }


    public String getPath() {
        return path;
    }

    public ArrayList<MyShape> getSqr() {
        return super.getSquares();
    }

    public void load() throws IOException {
        Scanner in = new Scanner(Paths.get(path), "UTF-8"); //读如入
        String str;
        while (in.hasNextLine()) {
            str = in.nextLine();
            String[] tmp = str.split(",");
            if (tmp.length != 6) continue; //不符合条件的数据丢弃

            Color color = Color.BLACK;
            if (tmp[5].equals("红色"))
                color = Color.RED;
            else if (tmp[5].equals("绿色"))
                color = Color.GREEN;
            else if (tmp[5].equals("粉色"))
                color = Color.PINK;

            if (tmp[0].equals("r")) {
                MyRectangle r = new MyRectangle(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]),
                        Integer.valueOf(tmp[3]), Integer.valueOf(tmp[4]), color);
                getSqr().add(r);
                //System.out.println(arr.isEmpty());
            } else if (tmp[0].equals("e")) {
                MyEllipse e = new MyEllipse(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]),
                        Integer.valueOf(tmp[3]), Integer.valueOf(tmp[4]), color);
                getSqr().add(e);
            }
        }
    }
    public void paintComponent(Graphics g) { //画组件
        for (MyShape s : getSqr()) {
            s.Draw((Graphics2D) g);
        }
    }

}