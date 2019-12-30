package Homework.ex4;

import Homework.ex4.rectangle;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实验四：继承与接口：画板
 */
public class dbtest {
    public static void main(String[] args) throws IOException {
       drawingBoard db = new drawingBoard("ss.txt");
       db.load();
       db.draw();
    }
}
