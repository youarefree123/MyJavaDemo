package Generic;


import java.util.Arrays;

class InsertSort {
    public static void sort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //对已经排序好的元素比较，找到一个比
                // 插入元素大的元素 交换位置
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}


    class BubbleSort {
        public static void sort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    //如果当前元素比后一位元素大 交换位置
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }


        class MergeSort{
            public static void merge(int[] arr ,int left ,int middle, int right){
                //申请合并空间 大小为两个已经排序序列之和
                int[] temp = new int[right-left+1];
                //i 和 j为两个已经排好序的数组的起始位置
                int i = left;
                int j = middle + 1;
                int k = 0;

                //排序
                while(i <= middle && j <= right){
                    if(arr[i] < arr[j])
                        temp[k++] = arr[i++];
                    else
                        temp[k++] = arr[j++];
                }
                //将左边剩余元素写入合并空间
                while (i <= middle) {
                    temp[k++] = arr[i++];
                }
                //将右边剩余的元素写入合并空间
                while (j <= right) {
                    temp[k++] = arr[j++];
                }
                //将排序后的数组写回原来的数组
                for (int l = 0; l < temp.length; l++) {
                    arr[l + left] = temp[l];
                }
            }

            public static void mergeSort(int[] arrays, int left, int right){
                //        如果数组还可以拆分
                if(left < right){
                    int middle = (left+right)/2;
                    //拆分左边数组
                    mergeSort(arrays, left, middle);
                    //拆分右边数组
                    mergeSort(arrays, middle + 1, right);
                    //合并
                    merge(arrays, left, middle, right);
                }
            }
        }


class QuickSrot{
    public static void sort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        //设置数组的起始位置 i 结束位置j 基准 pivot 为数组的中间
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            //当数组小于基准 循环结束后 相当于i所处的位置的值为大于基准的元素
            while (arr[i] < pivot) {
                ++i;
            }
            //当数组大于基准 循环结束后 相当于j所处的位置的值为小于于基准的元素
            while (arr[j] > pivot) {
                --j;
            }
            //如果i<j 那么则将交互i j对应位置的值
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                //将指针继续移动
                ++i;
                --j;
            } else if (i == j) {
//如果i=j 那么说明本次排序已经结束 将i++ 如果这里不使用i++ 那么后面的sort(arr,i,tail)将改为sort(arr,i+1,tail)
                ++i;
            }
        }
        //继续将数组分割
        sort(arr, head, j);
        sort(arr, i, tail);
    }
}








public class Sort {


    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        MergeSort.mergeSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}


