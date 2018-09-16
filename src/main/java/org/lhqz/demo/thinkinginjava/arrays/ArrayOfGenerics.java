package org.lhqz.demo.thinkinginjava.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {

    /*
    如果知道将来不会向上转型，并且需求也相对比较简单，那么仍旧可以创建泛型数组，它可以提供基本的编译期类型检查。
    但是，泛型容器总是比泛型数组更好的选择。
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //编译器不让实例化泛型数组，但是，允许创建对这种数组的引用。
        //可以通过编译
        List<String>[] ls;
        List[] la = new List[10];
        //可以创建非泛型的数组，然后将其转型
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<String>();
        //编译错误
        //ls[1] = new ArrayList<Integer>();

        //数组是协变类型的，List<String>[]也是一个Object[]
        Object[] objects = ls;
        //将一个ArrayList<Integer>赋值到数组中，不会有编译期或运行时错误
        objects[1] = new ArrayList<Integer>();

        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }
    }

}
