package org.lhqz.demo.thinkinginjava.typeinfo.rtti;

import java.util.Arrays;
import java.util.List;

import static org.lhqz.demo.tools.Print.*;

abstract class Shape {
    void draw() {
        println(this + ".draw()");
    }

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
 * 揭示了面向对象设计中许多有趣(并且复杂的)问题
 * 如何组织程序
 * <p>
 * 1.RTTI：假定在编译时已经知道了所有的类型，在运行时识别一个对象的类型
 * 2.反射：允许在运行时发现和使用类的信息
 * <p>
 * 面向对象编程中基本的目的是：让代码只操纵对基类的引用
 */
public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

}