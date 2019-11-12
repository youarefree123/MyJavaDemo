package Homework;

import java.io.FileOutputStream;
import java.io.IOException;

public class dbtest {
    public static void main(String[] args) throws IOException {

     ///  drawingBoard db = new drawingBoard("ss.txt");
     ///  db.load();
     ///  db.draw();
        rectangle juxing = new rectangle(10, 8, 1, 6, "红色");
        String s1 = juxing.dra();
        byte[] bytes = s1.getBytes();
        FileOutputStream fos=new FileOutputStream("G:\\shuchu\\a.txt");
        fos.write(bytes);
        fos.close();


    }

}
