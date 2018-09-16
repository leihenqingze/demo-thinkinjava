package org.lhqz.demo.thinkinginjava.arrays;

import java.util.Arrays;

import static org.lhqz.demo.tools.Print.*;

public class MultidimensionaPrimitiveArray {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        println(Arrays.deepToString(a));

    }

}