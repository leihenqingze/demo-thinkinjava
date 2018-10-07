package org.lhqz.demo.thinkinginjava.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Java中的每个类从根本上都是继承自Object，标准容器类自然也不例外。因此容器类都有toString()方法，
 * 并且重写了该方法，使得它生成的String结果能表达容器自身，以及容器所包含的对象。
 * 会遍历容器中包含的所有对象，调用每个元素上的toString()方法。
 *
 * 当需要改变字符串的内容时，String类的方法都会返回一个新的String对象。
 * 同时，如果内容没有发生变化，String的方法只是返回对象的引用而已。
 * 这可以节约存储空间以及避免额外的开销。
 */
public class InfiniteRecursion {

    @Override
    public String toString() {
        //会调用对象自身的toString()方法，从而造成递归
        //可以使用Object.toString()或super.toString()
        return " InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }

}