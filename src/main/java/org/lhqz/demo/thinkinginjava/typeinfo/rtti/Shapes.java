package org.lhqz.demo.thinkinginjava.typeinfo.rtti;

import java.util.Arrays;
import java.util.List;

import static org.lhqz.demo.thinkinginjava.util.Print.*;

abstract class Shape {
    //使用this，间接地调用了toString()
    //如果某个对象出现在字符串表达式中(涉及 "+" 和字符串对象的表达式)，toString()方法就会被自动调用,
    //以生成表示该对象的String
    void draw() {
        print(this + ".draw()");
    }

    //使用abstract，以此强制继承者覆写该方法，并可以防止对无格式的Shape的实例化
    //每个派生类都要覆盖(从Object继承来的)toString()方法，这样draw()在不同情况下就打印出不同的消息(多态)。
    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

/**
 * 运行时类型信息使得可以在程序运行时发现和使用类型信息。
 * 它使你从只能在编译期执行面向类型的操作的禁锢中解脱了出来，并且可以使用某些非常强大的程序。
 * 对RTTI的需要，揭示了面向对象设计中许多有趣(并且复杂的)问题，同时也提出了如何组织程序的问题。
 * <p>
 * Java在运行时识别对象和类的信息的两种方式。
 * 1.RTTI：假定在编译时已经知道了所有的类型，在运行时识别一个对象的类型
 * 2.反射：允许在运行时发现和使用类的信息
 * <p>
 * 一个典型的类层次结构是，基类位于顶部，派生类向下扩展。
 * 面向对象编程中基本的目的是：让代码只操纵对基类的引用。
 * 这样，如果要添加一个新类来扩展程序，就不会影响到原来的代码。
 * <p>
 * 基类中经常动态绑定一些方法，目的是让客户端程序员使用泛化的引用来调用这些方法。
 * 这些方法在所有派生类里都会被覆盖，并且由于它是动态绑定的，
 * 所以即使是通过泛化的引用来调用，也能产生正确行为。这就是多态。
 * <p>
 * 因此，通常会创建一个具体对象，把它向上转型成基类(忽略对象的具体类型)，
 * 并在后面的程序中使用匿名的基类引用。
 */
public class Shapes {

    public static void main(String[] args) {
        /*
            在向上转型为Shape的时候也丢失了Shape对象的具体类型。对于数组而言，它们只是Shape类的对象。

            当从数组中取出元素时，这种容器——实际上它将所有的事物都当作Object持有——会自动将结果转型为Shape。
            这是RTTI最基本的使用形式，因为在Java中，所有的类型转换都是在运行时进行正确性检查的。
            这也是RTTI名字的含义：在运行时，识别一个对象的类型。

            在这个例子中，RTTI类型转换并不彻底：Object被转换为Shape，而不是具体类型。
            这是因为目前我们只知道这个List<Shape>保存的都是Shape。在编译时，将由容器和Java的泛型系统来强制确保这一点，
            而在运行时，由类型转换操作来确保这一点。

            接下来就是多态机制的事情了，Shape对象实际执行什么样的代码，是由引用所指向的具体对象而决定的。
            你希望大部分代码尽可能少地了解对象的具体类型，而是只与对象中的一个通用表示打交道。
            这样代码会更加容易写，读，且更便于维护；设计也更容易实现，理解和改变，所以多态是面向对象编程的基本目标。
            
            使用RTTI，可以查询某个Shape引用所指向的对象的确切类型，然后选择或剔除特例。
         */
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapes) {
            shape.draw();
            //这里获取了每个对象对应的Class对象，从打印结果来看，
            //对象在转型的过程中对象的类型并没有真的发生变化，
            //对象只是指向了一个上层类型的引用。
            print(shape.getClass().getSimpleName());
        }
    }

}