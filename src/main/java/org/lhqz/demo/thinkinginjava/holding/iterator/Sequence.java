package org.lhqz.demo.thinkinginjava.holding.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.lhqz.demo.tools.Print.println;

public class Sequence {

    private List<Integer> items;

    private int next = 0;

    public Sequence() {
        items = new ArrayList<>();
    }

    public void add(Integer x) {
        items.add(x);
    }

    private class SequenceSelector implements Iterator<Integer> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return (i != items.size());
        }

        public Integer next() {
            Integer item = items.get(i);
            i++;
            return item;
        }
    }

    private Iterator<Integer> selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Iterator<Integer> selector = sequence.selector();
        while (selector.hasNext()) {
            println(selector.next() + " ");
        }
    }

}