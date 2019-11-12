package Basic;

/*
从控制台输入字符串 a 和字符串 b
比较字符串 a 和字符 b 是否完全一致，长度，内容等完全一致。
如果完全一致，输出相同，如果不一致，输出不同。
禁止使用equals方法
 */

import java.util.Scanner;

public class ContrastString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        for (int i = 0 ; i < (s1.length() > s2.length() ? s1.length() :s2.length()) ;i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                System.out.println("不同");
                return;
            }
        }
        System.out.println("相同");
    }
}
