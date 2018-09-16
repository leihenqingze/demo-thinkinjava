package org.lhqz.demo.thinkinginjava.containers.maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.lhqz.demo.tools.Print.println;

public class AssociativeArrayTest {

    private static void fillMap(Map<String, String> map) {
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            println("Too many objects");
        }
        println(map);
        println(map.get("ocean"));
    }

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        fillMap(map);
        Assert.assertEquals(7, map.size());

        map = new TreeMap<>();
        fillMap(map);
        Assert.assertEquals(7, map.size());

        map = new LinkedHashMap<>();
        fillMap(map);
        Assert.assertEquals(7, map.size());
    }

    @Test
    public void counting() {

        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("ww");
        list.add("zs");

        AssociativeArray<String, Integer> counting = new AssociativeArray<>(10);
        for (int i = 0; i < list.size(); i++) {
            Integer count = counting.get(list.get(i));
            if (Objects.isNull(count)) {
                counting.put(list.get(i), 1);
            } else {
                counting.put(list.get(i), ++count);
            }
        }

        println(counting);

    }

}