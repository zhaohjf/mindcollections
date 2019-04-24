package java.zhj.mindcollections.java8.lambda;

import javax.swing.text.DateFormatter;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhaohongjie on 2018/11/9.
 */
public class LambdaTestDemo1109 {

    public static void main(String[] args) {

        /**
         * 虽然没有使用FunctionalInterface注解，但ActionListener是一个只有一个方法的接口
         * 因此，可以被看作是一个函数接口。
         *
         */
        ActionListener actionListener = event -> System.out.println("click the button");

        Runnable runnable = () -> System.out.println();

        BinaryOperator<Long> binaryOperator = (x, y) -> x + y;

        Supplier<ThreadLocal<Long>> factory = () -> new ThreadLocal<>();
        ThreadLocal<Long> threadLocal1 = factory.get();

        Supplier<ThreadLocal<DateFormatter>> supplier = () -> {
            ThreadLocal<DateFormatter> threadLocal = new ThreadLocal<>();
            threadLocal.set(new DateFormatter());
            return threadLocal;
        };

        ThreadLocal<ThreadLocal<DateFormatter>> threadLocalThreadLocal = ThreadLocal.withInitial(() -> {
            ThreadLocal<DateFormatter> threadLocal = new ThreadLocal<>();
            threadLocal.set(new DateFormatter());
            return threadLocal;
        });

        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        System.out.println(count);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 1);
        List<Integer> stillOrdered = numbers.stream().map(x->x+1)
                .collect(Collectors.toList());
        stillOrdered.stream().forEach(c -> System.out.println(c));

        System.out.println();

        TreeSet<Integer> treeSet = numbers.stream().map(x -> x * 2).collect(Collectors.toCollection(TreeSet::new));
        treeSet.stream().forEach(c -> System.out.println(c));

    }
}
