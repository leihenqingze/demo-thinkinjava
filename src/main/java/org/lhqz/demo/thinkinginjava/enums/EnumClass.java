package org.lhqz.demo.thinkinginjava.enums;

import static org.lhqz.demo.tools.Print.*;

enum Shrubbery {GROUND, CRAWLING, HANGING}

/**
 * 关键字enum可以将一组具名的值的有限集合创建为一种新的类型，
 * 而这些具名的值可以作为常规的程序组件使用，这是一种非常有用的功能。
 * 创建enum时，编译器会生成一个相关的类，这个类继承自java.lang.Enum。
 * enum是final类，不能继承。
 */
public class EnumClass {

    public static void main(String[] args) {
        //返回enum实例的数组，而且该数组中的元素严格保持其在enum中声明时的顺序
        for (Shrubbery s : Shrubbery.values()) {
            //enum实例在声明时的次序,从0开始
            println(s + " ordinal:" + s.ordinal());
            //实现了Comparable和Serializable接口
            print(s.compareTo(Shrubbery.CRAWLING) + "\t");
            //可以使用==来比较enum实例,编译器会自动提供equals()和hashCode()方法
            print(s.equals(Shrubbery.CRAWLING) + "\t");
            println(s == Shrubbery.CRAWLING);
            //获取enum类名
            println(s.getDeclaringClass());
            //返回enum实例声明的名字，这与使用toString()方法效果相同
            println(s.name());
            println("--------------------------------");
        }

        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            //static方法,根据给定的名字返回相应的enum实例,如果不存在给定名字的实例,将会抛出异常
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            println(shrubbery);
        }
    }

}