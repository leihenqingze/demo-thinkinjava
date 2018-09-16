package org.lhqz.demo.thinkinginjava.reusing;

class A{}

class B{}

class C extends A{
    private B b;
}

public class Demo {

    public static void main(String[] args) {
        C c = new C();
    }

}
