package Homework;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputOutputFile {
    public static void main(String[] args) throws IOException
    {
        @SuppressWarnings("resource")
        Scanner infile = new Scanner(Paths.get("./bin/myfile.txt"),"UTF-8");

        while(infile.hasNextLine())
        {
            String x = infile.nextLine();
            System.out.println(x);
        }

//      FileOutputStream fileWriter=new FileOutputStream("./bin/outfile.txt");
//      OutputStreamWriter writer=new OutputStreamWriter(fileWriter, "UTF-8");
//      try {
//          writer.write("我们都是16级计科的，我们都很爱编程");
//      } catch (Exception e) {
//          // TODO: handle exception
//      }finally{
//          writer.close();
//      }
    }
}