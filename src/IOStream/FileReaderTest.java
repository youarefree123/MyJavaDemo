package IOStream;
/*
读取一个.java文件，并打印在控制台上
 */

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(".\\src\\IOStream\\FileReaderDemo.java");
        char[] buf = new char[1024];
        int num ;
        while((num = fr.read(buf))!= -1)
            System.out.println(new String(buf));
    }
}
