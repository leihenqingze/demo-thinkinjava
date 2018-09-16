package org.lhqz.demo.thinkinginjava.holding.container;

import org.lhqz.demo.thinkinginjava.innerclasses.Selector;

import static org.lhqz.demo.tools.Print.*;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private List<Integer> items;

    private int next = 0;

    public Sequence() {
        items = new ArrayList<>();
    }

    public void add(Integer x) {
        items.add(x);
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.size();
        }

        public Integer current() {
            return items.get(i);
        }

        public void next() {
            if (i < items.size()) {
                i++;
            }
        }
    }

    private Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            println(selector.current() + " ");
            selector.next();
        }
    }

}