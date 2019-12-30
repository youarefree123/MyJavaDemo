package Homework;


import java.util.Scanner;

/**
 * 实验一：打印三角形
 */
public class ex1 {
    public static void main(String[] args) {
        System.out.println("Input N:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 1 ; i <= N ; i++){
            for(int j = N-i ; j > 0 ; j--){
                System.out.print(" ");
            }
            for(int j = 1 ; j <= 2*i-1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
