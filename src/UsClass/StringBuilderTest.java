package UsClass;

public class StringBuilderTest {
    public static void main(String[] args) {
        //定义个初始化一个stringBuilder类的字符串s
        StringBuilder s = new StringBuilder("I");
        //在s后面添加字符串"java"
        s.append("java");
        //在s[1]的位置上插入字符串
        s.insert(1," love ");
        String t = s.toString(); //转换为字符串
        System.out.println(t);
    }
}
