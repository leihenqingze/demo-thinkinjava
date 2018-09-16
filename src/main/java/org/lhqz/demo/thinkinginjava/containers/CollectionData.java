package org.lhqz.demo.thinkinginjava.containers;

import org.lhqz.demo.thinkinginjava.arrays.Generator;

import java.util.ArrayList;

/**
 * 适配器模式：它将Generator适配到Collection的构造器
 * 这个类使用Generator在容器中放置所需数量的对象，然后所生产的容器可以传递给任何Collection的构造器，
 * 这个构造器会把其中的数据复制到自身中。
 *
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    //泛型方法可以减少在使用类时所必需的类型检查数量
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }

}