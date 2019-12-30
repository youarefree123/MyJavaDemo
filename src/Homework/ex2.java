package Homework;

import java.util.Scanner;

/**
 * 实验一：打印镂空三角形
 */
public class ex2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input The N:");
        int N = in.nextInt();
        for(int i = 0 ; i < N ; i++){
            for(int j = N-i-1 ; j >= 0 ; j--){
                System.out.print(" ");
            }
            if(i != N-1 && i != 0){
                System.out.print("*");
                for(int j = 2*i-1 ; j > 0 ; j--){
                    System.out.print(" ");
                }
                System.out.print("*");
            }

            else if(i == 0){
                System.out.print("*");
            }
            else if( i == N-1){
                for(int j = 0 ; j < 2*i+1 ; j++){
                    System.out.print("*");
                }
            }
            System.out.println();

        }

    }

}

