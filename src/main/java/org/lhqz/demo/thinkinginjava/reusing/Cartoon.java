package org.lhqz.demo.thinkinginjava.reusing;

import static org.lhqz.demo.tools.Print.*;

/**
 * 从外部分来看，它就像是一个与基类具有相同接口的新类，或许还会有一些额外得方法和域。
 * 当创建一个导出类的对象是，该对象包含了一个基类的子对象。
 * 这个子对象与你用基类直接创建的对象是一样的。
 * 二者区别在于，后者来自于外部，而基类的子对象被包装在导出类对象内部。
 * <p>
 * 对基类子对象的正确初始化也是至关重要的，而且也仅有一种方法来保证这一点:
 * 在构造器中调用基类构造器来执行初始化，而基类构造器具有执行基类初始化所需要的所有知识和能力。
 * Java会自动在导出类的构造器中插入对基类构造器的调用。
 * <p>
 * 构建过程是从基类"向外"扩散的，所有基类在导出类构造器可以访问它之前，就已经完成了初始化。
 * 如果没有明确定义构造器，编译器会创建一个默认的构造器，该构造器将调用基类的构造器。
 */
class Art {
    //总是会被调用
    //在导出类构造器之前被调用
    Art() {
        println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        println("Drawing constructor");
    }
}

public class Cartoon extends Drawing {

    public Cartoon() {
        println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }

}
