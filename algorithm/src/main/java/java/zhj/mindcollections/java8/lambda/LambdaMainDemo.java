package java.zhj.mindcollections.java8.lambda;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2018/10/17.
 */
public class LambdaMainDemo {

    public static void main(String[] args) {

        /**
         * lambda表达式，也被称之为闭包；允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据
         * 一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示
         */
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

        /**
         * 请注意参数e的类型是由编译器推测出来的。
         * 同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型
         */
        Arrays.asList("a", "b", "c").forEach((String e) -> System.out.print(e + " "));

        /**
         * 也可以使用花括号来实现复杂的函数体
         */
        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );

        /**
         * Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）
         *
         * separator 也可以声明为final，这两种写法是等价的
         */
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );

        /**
         * Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。
         * 如果lambda的函数体只有一行的话，那么没有必要显式使用return语句
         */
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            return result;
        } );

        Arrays.asList("a", "b", "c").stream().map(p -> p.hashCode()).forEach(c -> System.out.println(c));
    }
}
