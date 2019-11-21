package IOStream;
//文本文件复制

import javax.annotation.processing.Filer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
复制的原理：
    其实就是将c盘下的文件数据储存到D盘的一个文件中
步骤：
    1：在D盘创建一个文件，用于存储c盘文件中的数据
    2：定义读取流和c盘文件关联
    3：通过不断的读写完成数据存储
    4：关闭资源
 */
public class CopyTest {

    public static  void copy_1()throws IOException {
        //创建目的地
        FileWriter fw = new FileWriter("Copy_1.txt");
        //与已有文件关联
        FileReader fr = new FileReader("demo.txt");

        int ch = 0 ;
        while((ch = fr.read())!= -1)
            fw.write(ch);
        fw.close();
        fr.close();
    }

    public static void copy_2(){
        //创建目的地
        FileReader fr = null; //建立读出流的一个空对象
        FileWriter fw = null; //建立写入流的一个空对象
        try {
            fr = new FileReader("article.txt");
            fw = new FileWriter("Copy_2.txt");
            char[] buf = new char[1024];
            int len = 0;
            while((len=fr.read(buf)) != -1){
               fw.write(buf,0,len);
            }
        }
        catch (IOException e){
            System.out.println("文件创建失败:"+e.toString());
        }
        finally {
            try {
                if (fr != null)
                    fr.close();
                if (fw != null)
                    fw.close();
            }
            catch (IOException e){
                System.out.println("文件关闭失败"+e.toString());
            }
        }
    }

    public static void main(String[] args)throws IOException {
        copy_1();
        copy_2();
    }
}
