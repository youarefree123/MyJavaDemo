package String_Learning;

public class StringMethodDemo {

    private static void sop(Object obj){
        System.out.println(obj);
    }

    private static void method_get(){
        String str = "abcdeakpf";
        //长度
        sop(str.length());

        //根据索引获取字符，字符串越界异常
        sop(str.charAt(4));

        //根据字符串获取索引
        sop(str.indexOf('m',3));//如果没有找到返回-1

        //反向索引一个字符粗线的位置
        sop(str.lastIndexOf('a'));

    }
    public static void main(String[] args) {
        method_get();
    }
}
