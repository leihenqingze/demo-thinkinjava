package org.lhqz.demo.thinkinginjava.initialization.enums;

public class EnumOrder {

    public static void main(String[] args) {
        //用来按照enum常量得声明顺序，产生由这些常量值构成得数组
        for (Spiciness s : Spiciness.values()) {
            //编译器会创建ordinal()方法，用来表示某个特定enum常量得声明顺序
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }

}