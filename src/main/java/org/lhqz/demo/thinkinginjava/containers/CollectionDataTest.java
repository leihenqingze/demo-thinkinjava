package org.lhqz.demo.thinkinginjava.containers;

import org.lhqz.demo.thinkinginjava.arrays.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.lhqz.demo.tools.Print.*;

class Government implements Generator<String> {

    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basis for a system of " +
            "government").split(" ");

    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}

public class CollectionDataTest {

    public static void main(String[] args) {
        //所有的Collection子类型都有一个接收另一个Collection对象的构造器，
        //用接收的Collection对象中的元素来填充新的容器
        Set<String> set = new LinkedHashSet<>(
                new CollectionData<>(new Government(), 15));
        //addAll()方法是所有Collection子类型的一部分，它也可以用来组装现有的Collection
        set.addAll(CollectionData.list(new Government(), 15));
        println(set);
    }

}
