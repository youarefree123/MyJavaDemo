package Homework;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class drawingBoard {
    private String path;
    private ArrayList<Shape> arr;
    public drawingBoard(String path){
        this.path = path;
        arr = new ArrayList<Shape>();
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Shape> getArr() {
        return arr;
    }

    public void load()throws IOException{
        Scanner in = new Scanner(Paths.get(path),"UTF-8"); //读如入
        String str;
        while(in.hasNextLine()){
            str = in.nextLine();
            String[] tmp = str.split(",");
            if(tmp.length != 6) continue; //不符合条件的数据丢弃
            if(tmp[0].equals("r")){
                rectangle r = new rectangle(Integer.valueOf(tmp[1]),Integer.valueOf(tmp[2]),
                        Integer.valueOf(tmp[3]),Integer.valueOf(tmp[4]),tmp[5]);
                arr.add(r);
                //System.out.println(arr.isEmpty());
            }
            else if(tmp[0].equals("o")){
                oval o = new oval(Integer.valueOf(tmp[1]),Integer.valueOf(tmp[2]),
                        Integer.valueOf(tmp[3]),Integer.valueOf(tmp[4]),tmp[5]);
                arr.add(o);
            }
            else if(tmp[0].equals("l")){
                line L = new line(Integer.valueOf(tmp[1]),Integer.valueOf(tmp[2]),
                        Integer.valueOf(tmp[3]),Integer.valueOf(tmp[4]),tmp[5]);
                arr.add(L);
            }
        }
    }

    public void draw(){
        for (Shape it : arr){
            it.draw();
        }
    }
}
