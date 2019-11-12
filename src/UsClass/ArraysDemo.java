package UsClass;

import Basic.Array;

import java.util.Arrays;
import java.util.Random;

public class ArraysDemo {
    public static void main(String[] args) {
        int [] arr = new int[10];
        Arrays.fill(arr,9);  //将数组元素都设为9
        System.out.println("fill:"+Arrays.toString(arr));
        Random random = new Random();
        for(int i = 0 ; i < arr.length ; i++){
            //使用100内的随机数对数组赋值
            arr[i] = random.nextInt(101);
        }
        //输出重新复制后的数组
        System.out.println("重新赋值"+Arrays.toString(arr));
        //将索引为5的元素设为50
        arr[5] = 50;
        //排序
        Arrays.sort(arr);
        System.out.println("sort排序后: "+ Arrays.toString(arr));

        //查找50的位置
        int i = Arrays.binarySearch(arr ,50);
        System.out.println("值为50的元素索引为： "+i);

        //复制一份新数组
        int [] newArr = Arrays.copyOf(arr , arr.length);

        //比较
        System.out.println("equals: "+ Arrays.equals(arr,newArr));;

    }
}
