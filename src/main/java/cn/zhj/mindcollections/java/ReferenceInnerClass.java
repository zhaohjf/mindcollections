package cn.zhj.mindcollections.java;

/**
 * Created by zhaohongjie on 2018/10/18.
 */
public class ReferenceInnerClass {

    public InnerInterface sayHello(Person person) {
        return new InnerInterface() {
            @Override
            public String sayHello() {
                return person.sayHello();
            }
        };

        //person = new Person();
    }

    /**
     * output:
     * null Good morning
     * zhaohj Good morning
     * zhaohj Good morning
     *
     * @param args
     */
    public static void main(String[] args) {
        ReferenceInnerClass innerClass = new ReferenceInnerClass();
        Person person = new Person();

        InnerInterface inner1 = innerClass.sayHello(person);
        inner1.sayHello();

        person.setName("zhaohj");
        inner1.sayHello();

        person = new Person();
        person.setName("hello");
        inner1.sayHello();
    }
}

interface InnerInterface {
    String sayHello();
}

class Person {

    String name;

    public String sayHello() {
        System.out.println(name + " Good morning");

        return name + " Good morning";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}