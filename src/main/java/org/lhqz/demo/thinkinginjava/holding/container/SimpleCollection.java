package org.lhqz.demo.thinkinginjava.holding.container;

import static org.lhqz.demo.tools.Print.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection:一个独立元素的序列，这些元素都服从一条或多条规则
 * List:必须按照插入的顺序保存元素
 * Set:不能有重复的元素
 * Queue:按照排队规则来确定对象产生的顺序
 * Map:
 */
public class SimpleCollection {

    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }
        for (Integer i : c) {
            print(i + ", ");
        }
    }

}