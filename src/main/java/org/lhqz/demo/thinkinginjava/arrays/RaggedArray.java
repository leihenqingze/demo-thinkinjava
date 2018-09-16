package org.lhqz.demo.thinkinginjava.arrays;

import java.util.Arrays;
import java.util.Random;

import static org.lhqz.demo.tools.Print.*;

public class RaggedArray {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int[][][] a = new int[rand.nextInt(7)][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[rand.nextInt(5)];
            }
        }
        println(Arrays.deepToString(a));
    }

}