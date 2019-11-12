package Homework;


// 1968年1月1日为星期一

import java.util.Scanner;

public class badDate {

    public static void main(String[] args) {
        int []pin = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String xq = "星期五";
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int num = 0; //总天数
        for(int i = 1968 ; i < year ; i++){  //找到目标年份一月一日距离1970年1月日的总天数
            if((i % 4 == 0 && i % 100 != 0 ) || i % 400  == 0){ // 是闰年
                num += 366;
            }
            else{
                num += 365;
            }
        }
        int date = num % 7 ; //计算目标年元旦是周几 (0 到 6)
        int flag = 365;
        if((year % 4 == 0 && year % 100 != 0 ) || year % 400  == 0){ //如果目标年份是闰年
            flag += 1;
            pin[2] += 1;
        }

        for(int i = 1 ; i <= 12 ; i++) {
            for(int j = 1 ; j <= pin[i] ; j++){
                date = ++date % 7 ;
                if( j == 13 && date == 5){
                   if( i <= 9)
                       System.out.println(year+"."+"0"+i + "."+ j + " " + xq);
                   else
                       System.out.println(year+"." + i + "."+ j + " " + xq);
                }
            }

        }



    }
}
