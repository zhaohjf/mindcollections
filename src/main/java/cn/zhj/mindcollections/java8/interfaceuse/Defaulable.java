package cn.zhj.mindcollections.java8.interfaceuse;

import java.util.function.Supplier;

/**
 * Created by zhaohongjie on 2018/10/17.
 */
interface Defaulable {

    // Interfaces now allow default methods, the implementer may or
    // may not implement (override) them.
    default String notRequired() {
        return "Default implementation";
    }

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.notRequired());

        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.notRequired());
    }
}

class DefaultableImpl implements Defaulable {

}

class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}

interface DefaulableFactory {
    // Interfaces now allow static methods
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }
}

