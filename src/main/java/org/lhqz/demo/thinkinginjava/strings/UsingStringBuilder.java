package org.lhqz.demo.thinkinginjava.strings;

import java.util.Random;

/**
 * 如果你想走捷径。例如append(a + ":" + c)，
 * 那编译器就会掉入陷阱，从而为你另外创建一个StringBuilder对象处理括号内的字符串操作。
 * <p>
 * 如果拿不准该用那种方式，随时可以用javap来分析那你的程序。
 * <p>
 * StringBuffer是线程安全的，因此开销也会大些。
 */
public class UsingStringBuilder {

    public static Random rand = new Random(47);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }

}