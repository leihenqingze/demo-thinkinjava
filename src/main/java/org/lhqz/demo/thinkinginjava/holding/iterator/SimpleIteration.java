package org.lhqz.demo.thinkinginjava.holding.iterator;

import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pet;
import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pets;

import java.util.Iterator;
import java.util.List;

import static org.lhqz.demo.tools.Print.*;

/**
 * 迭代器是一个对象，它的工作是遍历并选择序列中的对象，而客户端程序员不必知道或关心该序列底层的结构。
 * 此外，迭代器通常称为轻量级对象：创建它的代价小。
 * 单向移动
 * 有了迭代器遍历时就不必关心元素的数量了.
 * 迭代器能够将遍历序列的操作与序列底层的结构分离。
 */
public class SimpleIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            println(p.id() + ":" + p + " ");
        }
        println();
        for (Pet p : pets) {
            println(p.id() + ":" + p + " ");
        }
        println();
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            //删除之前必须调用next()
            it.remove();
        }
        println(pets);
    }

}
