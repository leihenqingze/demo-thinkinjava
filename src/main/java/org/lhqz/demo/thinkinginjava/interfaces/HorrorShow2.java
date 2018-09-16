package org.lhqz.demo.thinkinginjava.interfaces;

interface Interface1 {
    void fun1();

    void fun2();
}

interface Interface2 {
    void fun3();

    void fun4();
}

interface Interface3 {
    void fun5();

    void fun6();
}

interface Interface4 extends Interface1, Interface2, Interface3 {
    void fun7();
}

class InterfaceVo {

}

class InterfaceDemo extends InterfaceVo implements Interface4 {

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

public class HorrorShow2 {

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
        InterfaceDemo demo = new InterfaceDemo();
        a(demo);
        b(demo);
        c(demo);
        d(demo);
    }

}
