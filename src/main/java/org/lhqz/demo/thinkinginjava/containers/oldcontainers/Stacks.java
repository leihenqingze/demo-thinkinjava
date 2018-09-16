package org.lhqz.demo.thinkinginjava.containers.oldcontainers;

import java.util.LinkedList;
import java.util.Stack;

import static org.lhqz.demo.tools.Print.*;

enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
}

public class Stacks {

    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        println("stack = " + stack);
        stack.addElement("The last line");
        println("element 5 = " + stack.elementAt(5));
        println("popping elements:");
        while (!stack.empty()) {
            println(stack.pop() + " ");
        }

        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values()) {
            lstack.addFirst(m.toString());
        }
        println("lstack = " + lstack);
        while (!lstack.isEmpty()) {
            println(lstack.removeFirst() + " ");
        }

        org.lhqz.demo.thinkinginjava.holding.list.Stack<String> stack2 =
                new org.lhqz.demo.thinkinginjava.holding.list.Stack();
        for (Month m : Month.values()) {
            stack2.push(m.toString());
        }
        println("stack2 = " + stack2);
        while (!stack2.empty()) {
            println(stack2.pop() + " ");
        }
    }

}
