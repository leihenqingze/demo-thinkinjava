package org.lhqz.demo.thinkinginjava.arrays;

import java.util.Arrays;

import static org.lhqz.demo.tools.Print.*;

/**
 * 数组保存的是对象的引用，基本数据类型的值
 */
public class ArrayOptions {

    public static void main(String[] args) {

        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];

        println("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (null == c[i]) {
                c[i] = new BerylliumSphere();
            }
        }

        BerylliumSphere[] d = {
                new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()
        };

        a = new BerylliumSphere[]{
                new BerylliumSphere(), new BerylliumSphere()
        };
        println("a.length = " + a.length);
        println("b.length = " + b.length);
        println("c.length = " + c.length);
        println("d.length = " + d.length);

        a = d;
        println("a.length = " + a.length);

        int[] e;
        int[] f = new int[5];
        println("f:" + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};
        println("f.length = " + f.length);
        println("g.length = " + g.length);
        println("h.length = " + h.length);
        e = h;
        println("e.length = " + e.length);
        e = new int[]{1, 2};
        println("e.length = " + e.length);
    }

}