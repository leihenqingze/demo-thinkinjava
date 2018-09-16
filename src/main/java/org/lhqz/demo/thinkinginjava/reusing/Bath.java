package org.lhqz.demo.thinkinginjava.reusing;

import static org.lhqz.demo.tools.Print.*;

/**
 * 编译器并不是简单地为每一个引用都创建默认对象，因为若真要那样做的话，
 * 就会在许多情况下增加不必要的负担。
 * <p>
 * 1.在定义对象的地方。这意味着它们总是能够在构造器被调用之前被初始化。
 * 2.在类的构造器中。
 * 3.就在正要使用这些对象之前，这种方式称为惰性初始化。在生成对象不值得及不必每次都生成对象的情况下，
 * 这种方式可以减少额外的负担。
 * 4.使用实例初始化。
 */
class Soap {
    private String s;

    Soap() {
        println("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {

    //在定义对象的地方
    private String s1 = "Happy",
            s2 = "Happy",
            s3, s4;
    private Soap castille;
    private int i;
    private float toy;

    //在类的构造器中
    public Bath() {
        //在所有初始化产生之前就已经执行了。如果没有在定义处初始化，
        //那么除非发生了不可避免的运行期异常，否则将不能保证信息在发送给对象引用之前已经被初始化。
        println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    //使用实例初始化，在
    {
        i = 47;
    }

    @Override
    public String toString() {
        //惰性初始化
        //确保所有的域在使用之时已被妥善初始化
        if (s4 == null) {
            s4 = "Joy";
        }
        return "s1 = " + s1 + "\n" +
                "s2 = " + s2 + "\n" +
                "s3 = " + s3 + "\n" +
                "s4 = " + s4 + "\n" +
                "i = " + i + "\n" +
                "toy = " + toy + "\n" +
                "castille = " + castille;
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        println(b);
    }

}