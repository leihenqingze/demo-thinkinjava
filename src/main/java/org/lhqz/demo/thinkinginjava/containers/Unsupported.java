package org.lhqz.demo.thinkinginjava.containers;

import java.util.*;

import static org.lhqz.demo.tools.Print.*;

public class Unsupported {

    static void test(String msg, List<String> list) {

        println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(subList);

        try {
            c.retainAll(c2);
        } catch (Exception e) {
            println("retainAll(): " + e);
        }

        try {
            c.removeAll(c2);
        } catch (Exception e) {
            println("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            println("clear(): " + e);
        }

        try {
            c.add("X");
        } catch (Exception e) {
            println("add(): " + e);
        }

        try {
            c.addAll(c2);
        } catch (Exception e) {
            println("addAll(): " + e);
        }

        try {
            c.remove("C");
        } catch (Exception e) {
            println("remove(): " + e);
        }

        try {
            ((List<String>) c).set(0, "X");
        } catch (Exception e) {
            println("set(): " + e);
        }

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList", Collections.unmodifiableList(new ArrayList<>(list)));
    }

}
