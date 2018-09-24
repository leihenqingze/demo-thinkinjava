package org.lhqz.demo.thinkinginjava.initialization;

public class DefaultConstructor2 {
    public DefaultConstructor2() {
        System.out.println("DefaultConstructor2");
    }

    public DefaultConstructor2(String label) {
        System.out.println("DefaultConstructor2 " + label);
    }

    public static void main(String[] args) {
        DefaultConstructor2 d = new DefaultConstructor2();
        DefaultConstructor2 b = new DefaultConstructor2("a");
    }
}