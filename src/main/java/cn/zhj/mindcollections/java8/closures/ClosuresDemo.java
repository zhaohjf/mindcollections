package cn.zhj.mindcollections.java8.closures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * java 8 闭包功能探究
 *
 * Created by zhaohongjie on 2018/10/18.
 */
public class ClosuresDemo {

    /**
     * Lambda表达式和之前版本中的匿名内部类一样，只能访问封闭范围内的final变量或是"事实上"的final变量，如
     * 下面方法中answer就是"事实上"的final变量，它并没有final修饰符；
     * 但当你将下面的answer++代码放开时，会发现有一个编译报错：
     * Variable used in lambda expression should be final or effectively final
     *
     */
    public void thread() {
        int answer = 42;
        Thread t = new Thread(() -> System.out.println("The answer is: " + answer));

        // error because incrementation of answer prevents it from being effectively final
        // answer++;
    }

    /**
     * closures in JavaScript
     * "A closures is a special kind of object that combines two things: a function,
     * and the environment in which that function was created. The environment
     * consists of any local variables that were in-scope at the time that the
     * closure wae created" -----MDN
     *
     *
     * function fn() { // the enclosing scope
            var myVar = 42;
            var lambdaFun = () => myVar;
            myVar++;
            console.log(lambdaFun()); // it prints 43
        }
     *
     * 在上面例子中，JavaScript的lambda表达式中仍可以使用已更改值的myVar。
     *
     * 事实上，在JavaScript当中，当一个新的方法被定义时，JavaScript会维护一个指向其闭包作用域一个指针，这一基础的机制允许JavaScript在创建
     * 闭包时为保存闭包中每个自由变量的存储位置——这些自由变量可以被当前方法本身，或其它方法来修改。
     *
     */

    /**
     * 其它语言，对于闭包的处理
     * 1，JavaScript：如上所述，JavaScript中一个方法在执行完以后，它的作用域并不会消失，其中变量仍然可以被使用或修改
     * 2，Scala:Scala编译器通过把局部变量包装在另一个对象中，以此来实现lambda表达式内外的数据同步。而Java的编译器由于未知的原因（
     *    怀疑是图省事儿？）没有做包装局部变量这件事儿，于是就只好强制用户把局部变量声明为final才能在匿名内部类中使用来避免数据不同
     *    步的问题。
     * 3, C#:同上
     *
     */

    /**
     * java创建闭包？
     *
     * Java只会将闭包中自由变量的值替换到lambda表达式中去使用，也就是说它是capture-by-value，不是capture-by-reference。
     *
     * （java替换到lambda表达式中的是一个值，而不是引用，当然这也和JVM本身机制也有一些关系，一个内部类的实例由某个一个方法返回后，
     *   这方法内的局部变量，在方法执行结束出虚拟机栈时会被统一销毁，这时，如果匿名类持有这些被销毁的方法局部
     *   变量，就会引发空指针问题；声明为final后，方法局部变量会被分配到常量池中，这样即使方法被销毁了，常量池中的变量仍然存在；
     *   或者，直接将外部引用变量直接赋值到匿名内部类中，这也没有空指针问题，但会有之前提到的数据同步问题，外部数据变化后，并不能
     *   同步到时匿名内部类中。）
     *
     * 也就是说即使myVar进行了增量操作，lambda表达式仍会输出42。编译器报错是为阻止这种无意义场景的发生，避免引发不必要的错误。
     * {@link cn.zhj.mindcollections.java.ReferenceInnerClass} 示例程序 利用对象引用证明。
     * 在基本类型情况下，编译器会进行检查来避免这种情况的发生，限制在lambda表达式（或匿名内部类）中使用的闭包自由变量的类型必须为
     * final类型或"事实上"的final类型（即，变量由内部类使用后不会再发生变化，这类变量称为——"事实上"的final类型）。
     *
     * 尽管有以上的限制，我们也可以说Java 8也是实现了闭包的。事实上，从更多理论的角度来讲，闭包closure唯一需要持有的就是自由变量
     * 的值value，在一个纯的函数语言中，这也正是应该被支持的——保证引用的透明性。
     *
     * 在之后的一些函数式语言中，如JavaScript，可能会提供获取自由变量存储位置的功能，但同时这也会带来一些问题。
     * 所以，在JavaScript的闭包中，我们可以做更多的事情。但相对引入的副作用而这么做是否值得，是否真有那么重要，这是一个需要思考的问题？
     *
     */


    /**
     * JavaScript中的副作用
     *
     * 为了更好的理解闭包，我们来看一下下面这段JavaScript的代码
     * function createCounter(initValue) { // the enclosing scope
     *      var count = initValue;
     *      var map = new Map();
     *      map.set('val', () => count);
     *      map.set('inc', () => count++);
     *      return map;
     * }
     * v = createCounter(42);
     * v.get('val')(); // returns 42
     * v.get('inc')(); // returns 42
     * v.get('val')(); // returns 43
     *
     * 每次调用createCounter方法时，它就会生成一个包含有两个lambda表达式的Map，这两个lambda表达式分别对闭包作用域内定义的变量count
     * 进行返回和递增操作。
     *
     * 换言之，方法[v.get('inc')()]的前一次调用会影响到后面方法调用的返回值。
     *
     * 另一个需要重点注意的是：当createCounter方法执行完毕后，方法作用域依然存在，而由方法中定义的两个lambda表达式来使用。
     *
     *
     */


    /**
     * Java方法中的局部变量是保存在虚拟机栈中的，一旦方法执行完毕，这些局部变量就会被从虚拟机栈中清除出去。已经被创建的lambda表达式（或匿名
     * 内部类）使用的是之前方法内局部变量的拷贝值（反编译内部类的代码可以看到，编译器默认为内部类实现了一个构造函数，参数就是闭包中的自由变量
     * ，将自由变量维护在了内部类自身当中）。
     *
     * 如果编译器允许第二个lambda表达式更换自己已经拷贝的自由变量，那么代码逻辑就很变得很复杂且混乱。
     *
     * 要想支持这种程度的闭包功能，Java就需要将闭包的作用域保存在堆内存当中，这样即使方法退出了，作用域仍然存活。
     * (Scala和C#采取的就是这种思路——编译器把自由变量封装在一个对象中，利用这个对象来实现内外的同步。在Java中，这个对象理所当然的会在堆内存中)
     *
     * @param initValue
     * @return
     */
    public static Map<String, Supplier> createCounter(int initValue) { // the enclosing scope
        int count = initValue;
        Map<String, Supplier> map = new HashMap<>();
        map.put("val", () -> count);
        // compiler error
        // 代码不会被编译通过，是因为这个lambda表达式试图修改变量count的值。
        // map.put("inc", () -> count++);
        return map;
    }
}











