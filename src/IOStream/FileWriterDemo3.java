package IOStream;
/*
对已有文件的续写
 */

import java.io.*;

public class FileWriterDemo3 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            //传递一个true参数，代表不覆盖已有文件，并再已有文件的末尾处进行数据续写
            fw = new FileWriter("demo.txt",true);
            fw.write("你好\n，谢谢");
        }
        catch (IOException e){
            System.out.println("catch"+e.toString());
        }
        finally {
            try{
                if (fw != null)
                    fw.close();
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
