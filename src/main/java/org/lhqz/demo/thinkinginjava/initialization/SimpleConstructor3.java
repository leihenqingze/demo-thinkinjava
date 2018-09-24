package org.lhqz.demo.thinkinginjava.initialization;

class Rock2 {
    //如果这是唯一的构造器，那么编译器将不会允许以其他任何方式创建对象
    Rock2(int i) {
        System.out.println("Rock " + i + " ");
    }
}

public class SimpleConstructor2 {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }

}