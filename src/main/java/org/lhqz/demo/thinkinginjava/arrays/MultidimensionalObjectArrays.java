package org.lhqz.demo.thinkinginjava.arrays;

import java.util.Arrays;

import static org.lhqz.demo.tools.Print.*;

public class MultidimensionalObjectArrays {

    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere()},
        };
        println(Arrays.deepToString(spheres));
    }

}
