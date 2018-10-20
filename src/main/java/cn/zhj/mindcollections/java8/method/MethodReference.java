package cn.zhj.mindcollections.java8.method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhaohongjie on 2018/10/20.
 */
public class MethodReference {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(new Student("a", 3), new Student("d", 9),
                new Student("b", 11), new Student("b", 4));
        /**
         * Comparator中，comparing()方法是一个静态方法，而thenComparing()方法则是一个默认方法
         * 可以看到，在保证Comparator接口兼容性的情况下，静态和默认方法为接口的扩展增加了更多的可能性
         * 同时，也使原有的接口在不破坏原有代码逻辑情况下，能够支持lambda表达式
         */
        studentList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));
        studentList.forEach(student -> System.out.println(student));
    }

    private static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "name: " + name + ", age: " + age;
        }
    }

}
