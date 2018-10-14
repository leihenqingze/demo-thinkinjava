package org.lhqz.demo.thinkinginjava.typeinfo.rtti;

import java.util.Random;

class Initable {

    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }

}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

/**
 * Java还提供了另一种方法来生成对Class对象的引用，即使用类字面常量。
 * 这样做不仅更简单，而且更安全，因为它在编译时就会受到检查（因此不需要置于try语句块中），
 * 并且它根除了对forName方法的引用，所以也更高效。
 * 类字面常量不仅可以应用于普通的类，也可以应用于接口、数组以及基本数据类型。
 * 另外，对于基本数据类型的包装器类，还有一个标准字段TYPE。
 * TYPE字段是一个引用，指向对应的基本数据类型的Class对象。
 * <p>
 * 当使用".class"来创建对Class对象的引用，不会自动地初始化该Class对象，为了使用类而做的准备工作实际包含三个步骤：
 * 1、加载，这是由类加载器执行的。该步骤将查找字节码，并从这些字节码中创建一个Class对象
 * 2、链接。在链接阶段将验证类中的字节码，为静态域分配存储空间，
 * 并且如果必需的话，将解析这个类创建的对其他类的所有引用。
 * 3、初始化。如果该类具有超类，则对其初始化，执行静态初始化器和静态初始化块。
 * 初始化被延迟到了对静态方法（构造器隐式地是静态的）或者非常数静态域进行首次引用时才执行。
 * <p>
 * 初始化有效地实现了尽可能的"惰性"。仅使用.class语法来获得对类的引用不会引发初始化。
 * 但是，为了产生Class引用，Class.forName()立即就进行了初始化。
 * <p>
 * 如果一个static final值是"编译期常量"，那么这个值不需要对类进行初始化就可以被读取。
 * <p>
 * 但是，如果只是将一个域设置为static和final的，还不足以确保这种行为，如常量由随机数确定。
 * <p>
 * 如果一个static域不是final的，那么在对它访问时，总是要求在它被读取之前，
 * 要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）。
 */
public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}