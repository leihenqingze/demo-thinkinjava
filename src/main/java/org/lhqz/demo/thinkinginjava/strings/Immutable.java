package org.lhqz.demo.thinkinginjava.strings;

import static org.lhqz.demo.thinkinginjava.util.Print.*;

/**
 * 可以证明，字符串操作是计算机程序设计中最常见的行为。
 * 尤其是在Java大展拳脚的<b>Web系统<b/>中更是如此。
 * <p>
 * String对象是不可变的。String类中每一个看起来会修改String值的方法，实际上都是创建了一个全新的String对象，
 * 以包含修改后的字符串内容。而最初的String对象则丝毫未动。
 * <p>
 * 对于一个方法而言，参数是为该方法提供信息的，而不是想让该方法改变自己的。
 * 在阅读这段代码时，读者自然就会有这样的感觉。这一点很重要，正是有了这种保障，才使得代码易于编写与阅读。
 */
public class Immutable {

    /*
        只有upcase()运行的时候，局部引用s才存在。一旦upcase()运行结束，s就消失了。
        upcase()的返回值，其实只是最终结果的引用。
     */
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    /*
        每当把String对象作为方法的参数时，都会复制一份引用，
        而该引用所指的对象其实一直待在单一的物理位置上，从未动过。
     */
    public static void main(String[] args) {
        String q = "howdy";
        print(q);   //howdy
        //传递的是引用的一个拷贝
        String qq = upcase(q);
        print(qq);  //HOWDY
        print(q);   //howdy
    }

}