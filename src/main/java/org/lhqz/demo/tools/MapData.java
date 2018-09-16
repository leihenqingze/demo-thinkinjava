package org.lhqz.demo.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData {

    public static <K, V> Map<K, V> map(List<K> list, V count) {
        Map<K, V> map = new HashMap<>();
        for (K k : list) {
            map.put(k, count);
        }
        return map;
    }

}