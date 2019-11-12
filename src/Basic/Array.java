package Basic;

public class Array {
    public static void main(String[] args) {
        int ages[];      //存放年龄的数组，类型为整型
        String [] name;  //存放名称的数组，类型为字符串型

        char [] symbol  = new char[10];
        int [] arg = {1,2,3,4,5};
        int [] a1 = {1,2,3,4};
        int [] a2 ;
        a2 = a1;  //可以将数组赋值给另一个数组
        //这里只是复制了一个引用, 即 a2 和 a1 是相同数组的不同名称。
    }
}
