package org.lhqz.demo.thinkinginjava.containers.maps;

import org.lhqz.demo.thinkinginjava.containers.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.lhqz.demo.tools.Print.*;

public class Maps {

    public static void printKey(Map<Integer, String> map) {
        println("Size = " + map.size() + ", ");
        println("Keys: ");
        println(map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        printKey(map);

        println("Values: ");
        println(map.values());
        println(map);
        println("map.containsKey(11):" + map.containsKey(11));
        println("map.get(11):" + map.get(11));
        println("map.containsValue(\"F0\"):" + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        println("Frist key in map: " + key);
        map.remove(key);
        printKey(map);
        map.clear();
        println("map.isEmpty():" + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        println("map.isEmpty():" + map.isEmpty());
    }

    public static void main(String[] args) {
        //随机访问速度最快，get(),put()时间为常量,可以甚至容量和负载因子，以调整容器的性能
        test(new HashMap<>());
        //红黑树，可以获取子树
        test(new TreeMap<>());
        //随机访问比HashMap慢一点，顺序访问最快
        test(new LinkedHashMap<>());
        //使用==替代equals()对key进行比较的散列映射。专为解决特殊问题而设计的
        test(new IdentityHashMap<>());
        //线程安全，不涉及同步加锁
        test(new ConcurrentHashMap<>());
        //如果映射之外没有引用key，则此key可以被回收
        test(new WeakHashMap<>());
        //test(new Properties());
    }

}
