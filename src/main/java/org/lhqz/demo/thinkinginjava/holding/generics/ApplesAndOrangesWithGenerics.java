package org.lhqz.demo.thinkinginjava.holding.generics;

import static org.lhqz.demo.tools.Print.*;

import java.util.ArrayList;

/**
 * 通过使用泛型，可以在编译期防止将错误类型的对象放置在容器中，
 * 在使用容器中的对象时，可以使用更加清晰的语法(不需要手动类型转换)，
 * 如果不需要使用每个元素的索引，可以使用foreach语法来选择List中的每个元素，
 * 集合中可以存放泛型指定的任何子类型，并在取出时自动执行向上转型。
 */
public class ApplesAndOrangesWithGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        //添加非Apple类型对象
        //编译时错误
        //apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            //无需强制转型
            println(apples.get(i).id());
        }
        //可以使用foreach语法
        for (Apple c : apples) {
            println(c.id());
        }
    }

}