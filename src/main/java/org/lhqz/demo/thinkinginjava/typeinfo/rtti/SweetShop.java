package org.lhqz.demo.thinkinginjava.typeinfo.rtti;

import static org.lhqz.demo.thinkinginjava.util.Print.*;

class Candy {
    //该子句在类第一次被加载时执行。
    //Class对象仅在需要的时候才被加载，static初始化是在类加载时进行的。
    static {
        print("Loading Candy");
    }
}

class Gum {
    static {
        print("Loading Gum");
    }
}

class Cookie {
    static {
        print("Loading Cookie");
    }
}

/**
 * 要理解RTTI在Java中的工作原理，首先必须知道类型信息在运行时是如何表示的。
 * 这项工作是由称为Class对象的特殊对象完成的，它包含了与类有关的信息。
 * 事实上，Class对象就是用来创建类的所有的"常规"对象的。
 * Java使用Class对象来执行RTTI，即使你正在执行的是类似转型这样的操作。
 * <p>
 * 类是程序的一部分,每个类都有一个Class对象。换言之,每当编写并且编译了一个新类,
 * 就会产生一个Class对象(更恰当地说,是被保存在一个同名的.class文件中)。
 * 为了生成这个类的对象,运行这个程序的Java虚拟机(JVM)将使用被称为"类加载器"的子系统。
 * <p>
 * 类加载器子系统实际上可以包含一条类加载器链，但是只有一个原生类加载器，它是JVM实现的一部分。
 * 原生类加载器加载的是所谓的可信类，包括Java API类，它们通常是从本地盘加载的。
 * 在这条链中，通常不需要添加额外的类加载器，但是如果你有特殊需求(例如以某种特殊的方式加载类，
 * 以支持Web服务器应用，或者在网络上下载类)，那么你有一种方式可以挂接额外的类加载器。
 * <p>
 * 所有的类都是在对其第一次使用时，动态加载到JVM中的。当程序创建第一个对类的静态成员的引用时，
 * 就会加载这个类。这个证明构造器也是类的静态方法，即使在构造器之前并没有使用static关键字。
 * 因此，使用new操作符创建类的新对象也会被当作对类的静态成员的引用。
 * <p>
 * 因此，Java程序在它运行之前并非被完全加载，其各个部分是在必需时才加载的。这一点与许多传统语言都不同。
 * <p>
 * 类加载器首先检查这个类的Class对象是否已经加载。如果尚未加载，默认的类加载器就会根据类名查找.class文件。
 * 在这个类的字节码被加载时，它们会接受验证，以确保其没有被破坏，并且不包含不良代码。
 * <p>
 * 一旦某个类的Class对象被载入内存，它就被用来创建这个类的所有对象。
 */
public class SweetShop {

    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            /*
                这个方法是Class类(所有Class对象都属于这个类)的一个static成员。
                Class对象就和其它对象一样,我们可以获取并操作它的引用(这是类加载器的工作)。
                forName()是取得Class对象的引用的一种方法。
                它是用一个包含目标类的文本名的String作输入参数,返回的是一个Class对象的引用。
                对forName()的调用是为了它产生的"副作用"：如果类还没有被加载就加载它，
                在加载的过程中，static子句被执行。

                无论何时，只要你想在运行时使用类型信息，就必须首先获得对恰当的Class对象的引用。
                Class.forName()就是实现此功能的便捷途径，因为你不需要为了获得Class引用而持有该类型的对象。
                但是，如果你已经有了一个感兴趣的类型的对象，那就可以通过调用getClass()方法来获取Class引用，
                这个方法属于Object的一部分，它将返回表示该对象的实际类型的Class引用。
             */
            Class.forName("org.lhqz.demo.thinkinginjava.typeinfo.rtti.Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }

}