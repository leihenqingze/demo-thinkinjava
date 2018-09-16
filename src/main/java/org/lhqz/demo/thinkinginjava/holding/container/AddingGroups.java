package org.lhqz.demo.thinkinginjava.holding.container;

import java.util.*;

public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        ////比构造器更快,更方便
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        //asList底层是固定长度的数组
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        //可以修改
        list.set(1, 99);
        //不可以添加新元素
        //list.add(21);
    }

}