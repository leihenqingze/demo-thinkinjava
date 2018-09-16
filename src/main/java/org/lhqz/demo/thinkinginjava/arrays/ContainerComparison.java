package org.lhqz.demo.thinkinginjava.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lhqz.demo.tools.Print.*;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere" + id;
    }
}

public class ContainerComparison {

    public static void main(String[] args) {
        //编译器类型安全
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }
        println(Arrays.toString(spheres));
        println(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerylliumSphere());
        }
        println(sphereList);
        println(sphereList.get(4));

        //可以持有基本数据类型
        int[] integers = {0, 1, 2, 3, 4, 5};
        println(Arrays.toString(integers));
        println(integers[4]);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        integerList.add(97);
        println(integerList);
        println(integerList.get(4));
    }

}