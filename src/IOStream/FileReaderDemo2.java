/*
第二种方式：通过字符数组进行读取
 */
package IOStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
    public static void main(String[] args)throws IOException {
        FileReader fr = new FileReader("demo.txt");
        char[] buf = new char[3];
        int num = fr.read(buf);
        System.out.println(num+"--"+new String(buf));
    }
}
