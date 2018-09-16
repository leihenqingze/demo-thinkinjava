package org.lhqz.demo.thinkinginjava.innerclasses;

import static org.lhqz.demo.tools.Print.println;

class SequenceDo {
    private String name;

    public SequenceDo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class SequenceDemo {

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new SequenceDo(String.valueOf(i)));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            println(selector.current() + " ");
            selector.next();
        }
        Selector reverseSelector = sequence.reverseSelector();
        while (!reverseSelector.end()) {
            println(reverseSelector.current() + " ");
            reverseSelector.next();
        }
    }

}