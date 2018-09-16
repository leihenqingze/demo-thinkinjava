package org.lhqz.demo.thinkinginjava.holding.container;

import java.util.Collection;
import java.util.HashSet;

import static org.lhqz.demo.tools.Print.print;

public class SimpleCollectionSet {

    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }
        for (Integer i : c) {
            print(i + ", ");
        }
    }

}