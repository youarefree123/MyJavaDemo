package Lambda;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PredicateDemo {
    public static void main(String[] args) {
        //简单使用  判断a是否大于5
        Predicate<Integer> predicate = a -> a > 50;
        System.out.println(predicate.test(52));
        //如果只断言int类型，可以直接使用 IntPredicate
        IntPredicate intPredicate = a->a>50;
        //System.out.println(intPredicate.test(50));
        IntStream.of(10,11,44,59,46,55,99,88,50)
        //结合filter过滤数字 小于或等于50的数字被过滤
            .filter(intPredicate)
                .peek(System.out::println).count();
    }
}
