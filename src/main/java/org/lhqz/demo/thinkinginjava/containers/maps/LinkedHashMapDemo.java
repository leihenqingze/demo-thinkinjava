package org.lhqz.demo.thinkinginjava.containers.maps;

import org.lhqz.demo.thinkinginjava.containers.CountingMapData;

import java.util.LinkedHashMap;

import static org.lhqz.demo.tools.Print.*;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap =
                new LinkedHashMap<>(new CountingMapData(9));
        println(linkedHashMap);
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.putAll(new CountingMapData(9));
        println(linkedHashMap);
        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }
        println(linkedHashMap);
        linkedHashMap.get(0);
        println(linkedHashMap);
    }

}
