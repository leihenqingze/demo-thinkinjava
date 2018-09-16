package org.lhqz.demo.thinkinginjava.innerclasses;

import static org.lhqz.demo.tools.Print.*;

/**
 * 局部内部类
 * 可以在代码块里创建内部类，典型的方式是在一个方法体里面创建。
 * 局部内部类不能有访问说明符，因为它不是外围类的一部分；局部内部类的名字在方法外是不可见的。
 * 但是它可以访问当前代码块内的常量以及外围类的所有成员。
 * <p>
 * 局部内部类当需要一个已命名的构造器，或者需要重载构造器，或者需要不止一个内部类对象使用。
 * 匿名内部类只能用于实例初始化。
 * <p>
 * 内部类标识符
 * 外围类+$+内部类
 * 匿名内部类，编译器会简单地产生一个数字作为其标识符。
 * 虽然这种命名格式简单而直接，但它还是很健壮的，足以应对绝大多数情况。
 * 这是Java的标准命名方式，所以产生的文件自动都是平台无关的。
 * Counter.class
 * LocalInnerClass$1.class
 * LocalInnerClass$LocalCounter.class
 * LocalInnerClass.class
 * <p>
 * 总结
 * 相比C++的多继承而言，Java的接口和内部类就容易理解多了。
 * <p>
 * 多态，接口、内部类，这些特性的使用应该是设计阶段考虑的问题。
 * 随着时间的推移，将能够更好地识别什么情况下使用接口，什么情况使用内部类，或者同时使用。
 * 当见到这些语言特性的实际应用时，就最终理解它们了。
 */

interface Counter {
    int next();
}

public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            public LocalCounter() {
                println("LocalCounter()");
            }

            @Override
            public int next() {
                println(name);//访问当前代码块内的常量
                return count++;//访问外围类成员
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        return new Counter() {
            //无构造器
            {
                println("Counter()");
            }

            @Override
            public int next() {
                println(name);//访问当前代码块内的常量
                return count++;//访问外围类成员
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner");
        Counter c2 = lic.getCounter2("Anonymous inner");
        for (int i = 0; i < 5; i++) {
            println(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            println(c2.next());
        }
    }

}
