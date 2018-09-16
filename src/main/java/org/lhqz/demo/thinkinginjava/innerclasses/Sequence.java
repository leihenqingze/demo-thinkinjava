package org.lhqz.demo.thinkinginjava.innerclasses;

import static org.lhqz.demo.tools.Print.println;

/**
 * 内部类的对象，能访问其外围对象的所有成员，而不需要任何特殊条件。此外，内部类还拥有其他外围类的所有元素的访问全。
 * 内部类能访问其外围类的方法和字段，就像自己拥有它们似的，这带来了很大的方便。
 * 内部类自动拥有对其外围类所有成员的访问权。当某个外围类的对象创建了一个内部类对象时，
 * 此内部类对象必定会秘密地捕获一个指向那个外围类对象的引用。
 * 然后，在你访问此外围类的成员时，就是用那个引用来选择外围类的成员。
 * 内部类的对象只能在与其外围类的对象相关联的情况下才能创建(在内部类是非static类时)。
 * 构建内部类对象时，需要一个指向其外围类对象的引用，如果编译器访问不到这个引用就会报错。
 * 绝大多数时候这都无需程序员操心。
 */
public class Sequence {

    private Object[] items;

    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        public Sequence sequence() {
            return Sequence.this;
        }

    }

    private class ReverseSelector implements Selector {
        private int i = items.length - 1;

        public boolean end() {
            return i == -1;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i > -1) {
                i--;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
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