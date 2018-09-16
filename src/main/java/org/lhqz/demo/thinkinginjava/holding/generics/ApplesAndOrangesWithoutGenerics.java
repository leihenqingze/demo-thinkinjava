package org.lhqz.demo.thinkinginjava.holding.generics;

import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;

    long id() {
        return id;
    }
}

class Orange {
}

public class ApplesAndOrangesWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //没有使用泛型,容器中存放的是Object类型
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        //可以添加任何类型的对象，在编译期和运行时都不会有问题
        //添加非Apple类型对象
        apples.add(new Orange());
        for (Object apple : apples) {
            //向上转型失败
            //运行时，这时候转型会失败
            ((Apple) apple).id();
        }
    }

}