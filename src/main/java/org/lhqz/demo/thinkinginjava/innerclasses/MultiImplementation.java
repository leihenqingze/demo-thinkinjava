package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * 内部类可以有多个实例，每个实例都有自己的状态信息，并且与外围类对象的信息相互独立。
 * 在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或继承同一个类。
 * 创建内部类对象的时刻并不依赖于外围类对象的创建。
 * 内部类并没有令人迷惑的"is-a"关系，它就是一个独立的实体。
 */

class D {
}

abstract class E {
}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

public class MultiImplementation {

    static void takeD(D d) {
    }

    static void takeE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takeD(z);
        takeE(z.makeE());
    }

}
