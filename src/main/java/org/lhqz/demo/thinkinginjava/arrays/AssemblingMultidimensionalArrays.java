package org.lhqz.demo.thinkinginjava.arrays;

import java.util.Arrays;

import static org.lhqz.demo.tools.Print.*;

public class AssemblingMultidimensionalArrays {

    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j;
            }
        }
        println(Arrays.deepToString(a));
    }

}
