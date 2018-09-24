package org.lhqz.demo.thinkinginjava.initialization;

public class DefaultConstructor3 {
    public DefaultConstructor3() {
        System.out.println("DefaultConstructor2");
    }

    public DefaultConstructor3(String label) {
        System.out.println("DefaultConstructor2 " + label);
    }

    public static void main(String[] args) {
        DefaultConstructor3 d = new DefaultConstructor3();
        DefaultConstructor3 b = new DefaultConstructor3("a");
    }
}