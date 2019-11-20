package IOStream;


import java.io.FileWriter;
import java.io.IOException;

/*
IO异常的处理方式
 */
public class FileWirterDemo2 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("demo.txt");
            fw.write("123");
        }
        catch (IOException e){
            System.out.println("catch:"+e.toString());
        }
        finally {
            try{
                if (fw != null) //只有当fw不为空的时候才能进行关操作
                    fw.close();
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
