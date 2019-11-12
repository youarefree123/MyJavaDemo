package Basic;

public class StringVar {
    public static void main(String[] args) {
        String s0 = "java";
        String s1 = new String("Java");
        int len = s0.length();
        System.out.println("用equals()比较，结果为"+s0.equals(s1));
        System.out.println("用equalsIgnoreCase()比较，结果为"+s0.equalsIgnoreCase(s1));

        String ss = s1 + "!";
        String s2 = s0.concat(s1);
        String s3 = s0 + s1;
        System.out.println(ss);
        System.out.println(s2);
        System.out.println(s3);

        char c = ss.charAt(1); //按照索引值寻找字符
        String s = "abcdefabc";
        System.out.println("字符a第一次出现的位置为"+s.indexOf('a'));
        System.out.println("字符串bc第一次出现的位置为"+s.indexOf("bc"));
        System.out.println("字符a最后一次出现的位置为"+s.lastIndexOf('a'));
        System.out.println("从位置3开始到结束的字符串"+s.substring(3));
        System.out.println("从位置3开始到6之间的字符串"+s.substring(3, 6));
    }
}
