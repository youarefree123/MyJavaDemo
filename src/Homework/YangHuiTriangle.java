package Homework;
import java.util.Scanner;

public class YangHuiTriangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入杨辉三角的行数：");
        int n = sc.nextInt();

        int[][] triangle = new int[n][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];

            for(int j =triangle.length-i-1 ; j >= 0 ; j--){
                System.out.print(" ");
            }

            for (int j = 0; j < triangle[i].length; j++) {
                if (i == 0 || j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }

    }

}
