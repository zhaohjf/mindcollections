#Java8  新特性

[TOC]

## 1.lambda表达式
lambda表达式（也称为闭包）是整个java8中最受期待的在Java语言层面上的改变。Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据。JVM平台上的很多语言（Groovy，Scala，……）一开始就支持Lambda，而Java程序员只能使用毫无新意的匿名类来代替lambda。

>事实上，Java实现的闭包是一种“功能受限的”闭包；在之前版本的Java中，匿名内部类使用外部的自由变量必须声明为final类型。java8中也只是将这一限制放宽至“事实上”的final类型，虽然不用在变量前加final关键字，但实际效果是一样的。

```java
/**
  * Lambda表达式和之前版本中的匿名内部类一样
  * 只能访问封闭范围内的final变量或是"事实上"的final变量，如
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
```

由于匿名内部类和外部方法形成了一个闭包，这样匿名内部类就能够访问外部方法的局部变量，看起来这是一件很正常的事情，Java也应该实现这样的特性，但这里存在一个问题
为什么**lambda或匿名内部类**访问外部自由变量需要为final类型，或是"事实上"的final类型？
- 一般匿名内部类的生命周期要比外部方法的生命周期要长，而且Java方法中局部变量的分配是在虚拟机栈中进行的，方法退出，虚拟机栈中对应的栈帧也会被删除，这样就访问不到外部的自由变量了；
- 为了解决这个问题，Java给出的做法是：将外部自由变量拷贝赋值到匿名内部类中。通过反编译匿名内部类可以看出，编译期为匿名内部类生成了一个构造函数，外部自由变量会传递给这个构造函数，由匿名内部类自身维护一个拷贝值。这样匿名内部类就不需要担心变量访问不到的问题了；
- 每个解决方案一般都会引入新的问题，以上也不例外。即，匿名内部类不再可以修改原来的局部变量，因为它持有的仅仅是一份复制品（**如果匿名内部类持有的是一个可变对象的引用，其实也是可以修改这个对象的状态的**）
- 为了解决新的问题，所以Java决定：干脆要求被匿名内部类访问的外部自由变量必须是final类型，一刀切，大家都别修改了！！！



