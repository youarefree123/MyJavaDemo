package Homework;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * JAVA API与字符串
 */
public class InputOutputFile {
    public static void main(String[] args) throws IOException
    {
        Map <String,Integer> map = new HashMap<String, Integer>();
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            fr = new FileInputStream("article.txt");
            fw = new FileOutputStream("demo.txt");
            int num;
            BufferedReader bf = new BufferedReader(new InputStreamReader(fr));
            String x = null;
            while((x = bf.readLine()) != null){
                x = x.replace(",", " ");
                x = x.replace(".", " ");
                x = x.replace(";", " ");
                //System.out.println(x);
                String[] arr = x.split("\\W++");
                //System.out.println(arr[0]);
                for(int i = 0 ; i < arr.length ; i++){
                    if (arr[i] == "") continue;
                    if (!map.containsKey(arr[i]))
                        map.put(arr[i],1);
                    else{
                        Integer v = map.get(arr[i]);
                        map.put(arr[i],v+1);
                    }
                }
            }


//                System.out.println(map.keySet());


            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //存放map中的每一个entry
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue() - o1.getValue());
                }
            });

//            System.out.println(map.entrySet());

            int cnt = 10;
            for(Map.Entry<String, Integer> t:list){
                if(cnt-- <= 0) return;
                String s = t.getKey()+":"+t.getValue()+"\n";
                byte[] bytes=s.getBytes();//转化为字节数组
                fw.write(bytes);
            }

        }
        catch (IOException e){
            System.out.println("catch:"+e.toString());
        }
        finally {
            try{
                if(fw != null)
                    fw.close();
                if (fr != null)
                    fr.close();
            }
            catch (IOException e){
                System.out.println("catch:"+e.toString());
            }
        }






//        while(infile.hasNextLine())
//        {
//            String x = infile.nextLine();
//            //String[] arr = x.split("[ ,.]");
//            //\w+ : 匹配所有的单词
//            //\W+ : 匹配所有非单词
//            String[] arr = x.split("\\W+");
//            for(int i = 0 ; i < arr.length ; i++){
//                if (!map.containsKey(arr[i]))
//                    map.put(arr[i],1);
//                else{
//                    Integer v = map.get(arr[i]);
//                    map.put(arr[i],v+1);
//                }
//            }
//            //System.out.println(x);
//        }










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