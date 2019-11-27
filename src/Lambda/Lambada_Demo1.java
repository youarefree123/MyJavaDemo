package Lambda;

/**
 * 无参数无返回值的lambda表达式
 */



public class Lambada_Demo1{
    interface cook{
        public abstract void invokecook();
    }

    public static void main(String[] args) {
        cook c = ()->System.out.println("吃饭");
        c.invokecook();
    }

}
