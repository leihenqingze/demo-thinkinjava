package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * outerObjectName.new InnerClassName
 * 告知某些其他对象，去创建其某个内部类的对象。
 * 要直接创建内部类的对象，必须使用外部类的对象来创建该内部类对象，这也解决了内部类名字作用域的问题。
 * 在拥有外部类对象之前是不可能创建内部类对象的。这是因为内部类对象会暗暗地连接到创建它的外部类对象上。
 */
public class DotNew {

    public class Inner {

    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
