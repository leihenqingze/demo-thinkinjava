package org.lhqz.demo.thinkinginjava.containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.lhqz.demo.tools.Print.*;

class SetType {

    int i;

    public SetType(int n) {
        i = n;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && i == ((SetType) obj).i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {

    public HashType(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {

    public TreeType(int n) {
        super(n);
    }


    @Override
    public int compareTo(TreeType o) {
        return (o.i < i ? -1 : (o.i == i ? 0 : 1));
    }
}

public class TypesForSets {

    static <T> Set<T> fill(Set<T> set, Class<T> type) {

        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return set;
    }

    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(),HashType.class);
        test(new LinkedHashSet<>(),HashType.class);
        test(new TreeSet<>(),TreeType.class);

        test(new HashSet<>(),SetType.class);
        test(new HashSet<>(),TreeType.class);
        test(new LinkedHashSet<>(),SetType.class);
        test(new LinkedHashSet<>(),TreeType.class);

        try {
            test(new TreeSet<>(),SetType.class);
        } catch (Exception e){
            println(e.getMessage());
        }
        try {
            test(new TreeSet<>(),HashType.class);
        } catch (Exception e){
            println(e.getMessage());
        }
    }

}