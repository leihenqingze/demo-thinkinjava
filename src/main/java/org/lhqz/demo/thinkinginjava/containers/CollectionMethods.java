package org.lhqz.demo.thinkinginjava.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.lhqz.demo.tools.Print.*;

public class CollectionMethods {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");

        println(c);

        Object[] array = c.toArray();
        String[] str = c.toArray(new String[0]);

        println("Collections.max(c) = " + Collections.max(c));
        println("Collections.min(c) = " + Collections.min(c));

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        println(c);
        c.remove(Countries.DATA[0][0]);
        println(c);
        c.remove(Countries.DATA[1][0]);
        println(c);

        c.removeAll(c2);
        println(c);
        c.addAll(c2);
        println(c);

        String val = Countries.DATA[3][0];
        println("c.contains(" + val + ") = " + c.contains(val));

        println("c.containsAll(c2) = " + c.containsAll(c2));

        Collection<String> c3 = ((ArrayList<String>) c).subList(3, 5);

        c2.retainAll(c3);
        println(c2);

        c2.retainAll(c3);
        println("c2.isEmpty() = " + c2.isEmpty());
        c = new ArrayList<>();
        c.addAll(Countries.names(6));
        println(c);
        c.clear();
        println("after c.clear():" + c);

    }

}
