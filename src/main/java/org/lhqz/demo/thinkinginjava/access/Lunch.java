package org.lhqz.demo.thinkinginjava.access;

//: access/Lunch.java
class Soup1 {
    private Soup1() {
    }

    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {
    private Soup2() {
    }

    private static Soup2 ps1 = new Soup2();

    //单例模式
    public static Soup2 access() {
        return ps1;
    }

    public void f() {
    }
}

public class Lunch {

    void testPrivate() {
        // 不能创建private构造器类的对象
        //! Soup1 soup = new Soup1();
    }

    void testStatic() {
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }

}