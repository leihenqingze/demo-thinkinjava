package org.lhqz.demo.thinkinginjava.strings;

import org.lhqz.demo.thinkinginjava.generic.coffee.Coffee;
import org.lhqz.demo.thinkinginjava.generic.coffee.CoffeeGenerator;

import java.util.ArrayList;

public class ArrayListDisplay {

    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<>();
        for (Coffee c : new CoffeeGenerator(10)) {
            coffees.add(c);
        }
        //会遍历容器中的所有对象的toString()方法
        System.out.println(coffees);
    }

}
