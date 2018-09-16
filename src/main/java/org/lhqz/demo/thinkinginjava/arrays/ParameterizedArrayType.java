package org.lhqz.demo.thinkinginjava.arrays;

import java.util.ArrayList;
import java.util.List;

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

/*
使用参数化方法而不使用参数化的方便之处在于：不必为需要应用的每种不同的类型都使用一个参数去实例化这个类，
并且可以定义为静态的。当然不能总是选择使用参数化方法而不是参数化类，但是它应该成为首选。
 */
class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

public class ParameterizedArrayType {

    public static void main(String[] args) {

        //不能实例化具有参数化类型的数组，擦除会移除参数类型信息，
        // 而数组必须知道它们所持有的确切类型，以强制保证类型安全
//        List<Integer>[] a = new ArrayList<Integer>[2];

        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
        ints2 = MethodParameter.f(ints);
        doubles2 = MethodParameter.f(doubles);
    }

}