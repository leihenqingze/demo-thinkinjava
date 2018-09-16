package org.lhqz.demo.thinkinginjava.holding.container;

import static org.lhqz.demo.tools.Print.*;

import java.util.*;

public class PrintingContainers {

    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        println(fill(new ArrayList<>()));
        println(fill(new LinkedList<>()));
        //最快的元素获取方式，适用于只关心元素是否存在，不关心存储顺序
        println(fill(new HashSet<>()));
        //比较结果排序
        println(fill(new TreeSet<>()));
        //插入顺序
        println(fill(new LinkedHashSet<>()));
        //key不可以重复，使用一种非常快的算法类控制顺序
        println(fill(new HashMap<>()));
        println(fill(new TreeMap<>()));
        //按照插入顺序保存key，同时还保留了HashMap的查询速度
        println(fill(new LinkedHashMap<>()));
    }

}