package Lambda;

//建立一个数组1, 23, 4, 4, 22, 34, 45, 11, 33
//        使用 lambda 求出数组中的最小数
//        将数组去重，并将去重后数组的每个元素乘以 2，
//        再求出乘以 2 后的数组的和，比如数组1,2,3,3，
//        去重后为1,2,3，乘以 2 后为2,4,6，最后的和为12。


import java.util.Arrays;

public class LambdaEX {
    public static void main(String[] args) {
        int[] arr = {1, 23, 4, 4, 22, 34, 45, 11, 33};
        System.out.println("最小数："+Arrays.stream(arr).min());
        System.out.println("数组去重乘2求和：" + Arrays.stream(arr).distinct().map((i) -> i * 2).count());
    }
}


