package org.lhqz.demo.thinkinginjava.containers.collections;

import java.util.*;

import static org.lhqz.demo.tools.Print.*;

public class Utilities {

    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args) {

        println(list);
        println("'list' disjoint (Four)?: " +
                Collections.disjoint(list,
                        Collections.singleton("Four")));
        println("max: " + Collections.max(list));
        println("min: " + Collections.min(list));
        println("max: w/comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        println("min: w/comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        println("indexOfSubList: " + Collections.indexOfSubList(list, sublist));
        println("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, sublist));
        Collections.replaceAll(list, "one", "Yo");
        println("replaceAll: " + list);
        Collections.reverse(list);
        println("reverse: " + list);
        //所有元素向后移动n个位置，将末尾的元素循环到前面来
        Collections.rotate(list, 3);
        println("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        //将src中的元素复制到dest
        Collections.copy(list, source);
        println("copy: " + list);
        //交换list中位置i与位置j的元素
        Collections.swap(list, 0, list.size() - 1);
        println("swap: " + list);
        //随机改变指定列表的顺序
        Collections.shuffle(list, new Random(47));
        println("shuffle: " + list);
        Collections.fill(list, "pop");
        //用对象x替换list中的所有元素
        println("fill: " + list);
        //返回等于x的元素个数
        println("frequency of 'pop': " + Collections.frequency(list, "pop"));
        //返回大小为n的List<T>，此List不可改变，其中的引用都指向x
        List<String> dups = Collections.nCopies(3, "snap");
        println("dups: " + dups);
        //当两个集合没有任何相同元素时，返回true
        println("'list' disjoint 'dups'?: " + Collections.disjoint(list, dups));
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<>();
        while (e.hasMoreElements()) {
            v.addElement(e.nextElement());
        }
        ArrayList<String> arrayList = Collections.list(v.elements());
        println("arrayList: " + arrayList);
    }

}
