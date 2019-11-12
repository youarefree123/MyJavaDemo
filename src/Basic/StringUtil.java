package Basic;

/*
你需要实现以下需求：
从控制台输入一行字符串
去除字符串中的所有空格
打印去除空格后的字符串
 */

import java.util.Scanner;
public class StringUtil {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        //获取String值
        String a=in.nextLine();
        StringBuilder stringBuilder = new StringBuilder(a);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i)==' ') {
                System.out.println(i);
                stringBuilder.deleteCharAt(i);
                i--;
            }else {
                stringBuilder.charAt(i);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}