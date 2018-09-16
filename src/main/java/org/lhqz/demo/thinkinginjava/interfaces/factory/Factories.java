package org.lhqz.demo.thinkinginjava.interfaces.factory;

import static org.lhqz.demo.tools.Print.*;

/**
 * 接口与工厂
 * 与直接调用构造器不同，在工厂对象上调用的是创建方法，而该工厂对象将生成接口的某个实现的对象。
 * 理论上，通过这种方式，我们的代码将完全与接口的实现分离，这就使得我们可以透明地将某个实现替换为另一个实现。
 * 为什么需要添加这种额外的间接性呢?一个常见的原因是想要创建框架。
 */

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {

    Implementation1() {
    }

    @Override
    public void method1() {
        println("Implementation1 method1");
    }

    @Override
    public void method2() {
        println("Implementation1 method2");
    }
}

class Implementation1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {

    Implementation2() {
    }

    @Override
    public void method1() {
        println("Implementation2 method1");
    }

    @Override
    public void method2() {
        println("Implementation2 method2");
    }
}

class Implementation2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation2();
    }
}

public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        //如果不是用工厂方法，你的代码就必须在某处指定将要创建的Service的确切类型，以便调用合适的构造器。
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }

}