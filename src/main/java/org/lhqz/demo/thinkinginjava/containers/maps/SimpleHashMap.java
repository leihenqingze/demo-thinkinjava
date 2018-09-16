package org.lhqz.demo.thinkinginjava.containers.maps;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Set;


/**
 * HashMap是通过数组+链表的方式进行存储的
 * 数组中存储key的hashcode
 * 不同的key可能会有相同的hashcode
 * 如果散列函数好，数组的每个位置就只有较少的值
 * @param <K>
 * @param <V>
 */
public class SimpleHashMap<K,V>  extends AbstractMap<K,V> {

    static final int SIZE = 997;

    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
