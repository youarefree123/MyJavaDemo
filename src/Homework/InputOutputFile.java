package Homework;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class InputOutputFile {
    public static void main(String[] args) throws IOException
    {
        Map <String,Integer> map = new HashMap<String, Integer>();

       // @SuppressWarnings("resource")
        Scanner infile = new Scanner(Paths.get("article.txt"),"UTF-8");//读取文件
        while(infile.hasNextLine())
        {
            String x = infile.nextLine();
            //String[] arr = x.split("[ ,.]");
            //\w+ : 匹配所有的单词
            //\W+ : 匹配所有非单词
            String[] arr = x.split("\\W+");
            for(int i = 0 ; i < arr.length ; i++){
                if (!map.containsKey(arr[i]))
                    map.put(arr[i],1);
                else{
                    Integer v = map.get(arr[i]);
                    map.put(arr[i],v+1);
                }
            }
            //System.out.println(x);
        }



        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //存放map中的每一个entry
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        int cnt = 10;
        for(Map.Entry<String, Integer> t:list){
            if(cnt-- <= 0) return;
            System.out.println(t.getKey()+"::"+t.getValue());
        }




}
}



//      FileOutputStream fileWriter=new FileOutputStream("./bin/outfile.txt");
//      OutputStreamWriter writer=new OutputStreamWriter(fileWriter, "UTF-8");
//      try {
//          writer.write("121");
//      } catch (Exception e) {
//          // TODO: handle exception
//      }finally{
//          writer.close();
//      }