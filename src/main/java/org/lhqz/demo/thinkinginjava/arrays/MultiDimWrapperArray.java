package org.lhqz.demo.thinkinginjava.arrays;

import java.util.Arrays;

import static org.lhqz.demo.tools.Print.*;

public class MultiDimWrapperArray {

    public static void main(String[] args) {
        Integer[][] al = {
                {1, 2, 3,},
                {4, 5, 6,}
        };

        Double[][][] a2 = {
                {{1.1, 2.2}, {3.3, 4.4}},
                {{5.5, 6.6}, {7.7, 8.8}},
                {{9.9, 1.2}, {2.3, 3.4}},
        };
        String[][] a3 = {
                {"The", "Quick", "Sly", "Fox"},
                {"Jumped", "Over"},
                {"The", "Lazy", "Brown", "Dog", "and", "friend"},
        };

        println("a1: " + Arrays.deepToString(al));
        println("a2: " + Arrays.deepToString(a2));
        println("a3: " + Arrays.deepToString(a3));

    }

}