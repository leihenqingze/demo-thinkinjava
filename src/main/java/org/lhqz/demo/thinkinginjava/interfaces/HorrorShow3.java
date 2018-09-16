package org.lhqz.demo.thinkinginjava.interfaces;

abstract class InterfaceVo2 implements Interface4 {

}

class InterfaceDemo2 extends InterfaceVo2 {


    @Override
    public void fun1() {

    }

    @Override
    public void fun2() {

    }

    @Override
    public void fun3() {

    }

    @Override
    public void fun4() {

    }

    @Override
    public void fun5() {

    }

    @Override
    public void fun6() {

    }

    @Override
    public void fun7() {

    }
}

public class HorrorShow3 {

    static void a(Interface1 a) {
        a.fun1();
        a.fun2();
    }


    static void b(Interface2 a) {
        a.fun3();
        a.fun4();
    }


    static void c(Interface3 a) {
        a.fun5();
        a.fun6();
    }


    static void d(Interface4 a) {
        a.fun7();
    }

    public static void main(String[] args) {
        InterfaceDemo2 demo = new InterfaceDemo2();
        a(demo);
        b(demo);
        c(demo);
        d(demo);
    }

}
