package org.lhqz.demo.thinkinginjava.initialization.thises;

public class ThisTest2 {

    public void f1() {
        f2();
        this.f2();
    }

    public void f2() {
    }

    public static void main(String[] args) {
        ThisTest2 thisTest = new ThisTest2();
        thisTest.f1();
    }

}
