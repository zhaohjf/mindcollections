package cn.zhj.mindcollections.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaohongjie on 2018/10/19.
 */
public class CustomizeFunctionInterface {

    public static void main(String[] args) {
        List<String> list = subList(Arrays.asList("a", "b", "d"), x -> x.subList(0, 1));
        list.forEach(c -> System.out.println(c));
    }

    public static List<String> subList(List<String> original, Transformer<List<String>> transformer) {
        return transformer.transformer(original);
    }

    // 这是泛型接口，不是泛型方法，所以方法中的T和接口声明中的T是一致的
    @FunctionalInterface
    public interface Transformer<T> {
        T transformer(T input);
    }
}
