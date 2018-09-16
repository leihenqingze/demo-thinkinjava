package org.lhqz.demo.thinkinginjava.arrays;

/**
 * 泛型在类或方法的边界处很有效，而在类或方法的内部，擦除通常会使泛型变得不适用。
 *
 * @param <T>
 */
public class ArrayOfGenericType<T> {

    T[] array;

    public ArrayOfGenericType(int size) {
//        array = new T[size];
        //编译期警告，可以将任何对象放在Object[]中
        array = (T[]) new Object[size];
    }

//    public <U> U[] makeArray(){
//        return new U[10];
//    }

}
