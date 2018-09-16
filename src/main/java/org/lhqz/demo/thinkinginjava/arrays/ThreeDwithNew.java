package org.lhqz.demo.thinkinginjava.arrays;

import java.util.Arrays;

import static org.lhqz.demo.tools.Print.*;

public class ThreeDwithNew {

    public static void main(String[] args) {
        int[][][] a = new int[2][2][4];
        println(Arrays.deepToString(a));
    }

}
