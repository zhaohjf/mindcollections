package zava.zhj.mindcollections.zava;

/**
 * 为什么Java中的匿名内部类只可以访问外部final的局部变量呢？
 *
 * 答案：Java为了避免数据不同步的问题，做出了匿名内部类只可以访问final的局部变量的限制。
 * Scala和C#的编译器通过把局部变量包装在另一个对象中，以此来实现lambda表达式内外的数据同步。而Java的编译器由于未知的原因（
 * 怀疑是图省事儿？）没有做包装局部变量这件事儿，于是就只好强制用户把局部变量声明为final才能在匿名内部类中使用来避免数据不同
 * 步的问题。
 *
 *
 * 内部类反编译：
 *  class InnerClassAnalysis$1 implements AnnoInner {
        int z;

        InnerClassAnalysis$1(InnerClassAnalysis this$0, int var2) {
            this.this$0 = this$0;
            this.val$x = var2;
            this.z = 100;
        }

        public void addXYZ() {
            int i = this.val$x + 100 + this.z;
            System.out.println(i);
        }
    }
 *
 * 匿名类会被编译成一个单独的类，返编译结果如上。可以看出外部变量是以构造参数的方式传入内部类的。
 *
 *
 * 内部类通过包含一个指向外部类的引用，做到自由访问外部环境类的所有字段，变相把环境中的自由变量封装到函数里，形成一个闭包。
 *
 * Created by zhaohongjie on 2018/10/18.
 */
public class InnerClassAnalysis {

    /**
     *
     * @param x
     * @return
     */
    public AnnoInner getAnnoInner(final int x) {
        final int y = 100;
        return new AnnoInner() {
            int z = 100;
            @Override
            public void addXYZ() {
                int i = x + y + z;
                System.out.println(i);
            }
        };
    }

    public static void main(String[] args) {
        InnerClassAnalysis innerClassAnalysis = new InnerClassAnalysis();
        innerClassAnalysis.getAnnoInner(10).addXYZ();
    }

}

interface AnnoInner {
    void addXYZ();
}
