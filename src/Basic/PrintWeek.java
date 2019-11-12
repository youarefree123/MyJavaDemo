package Basic;

import java.util.Scanner;

/*
从控制台获取一个整型参数
当输入数字 1 时输出今天是星期一
当输入数字 2 时输出今天是星期二
......
当输入数字 7 时输出今天是星期天
 */
public class PrintWeek {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        switch (n){
            case 1:
                System.out.println("今天是星期一");
                break;
            case 2:
                System.out.println("今天是星期二");
                break;
            case 3:
                System.out.println("今天是星期三");
                break;
            case 4:
                System.out.println("今天是星期四");
                break;
            case 5:
                System.out.println("今天是星期五");
                break;
            case 6:
                System.out.println("今天是星期六");
                break;
            case 7:
                System.out.println("今天是星期天");
                break;
        }
        return ;

    }
}
