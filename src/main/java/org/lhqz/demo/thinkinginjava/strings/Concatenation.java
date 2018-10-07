package org.lhqz.demo.thinkinginjava.strings;

/**
 * String对象是不可变的，可以给一个String对象加任意多的别名。因为String对象具有只读特性，
 * 所以指向它的任何引用都不可能改变它的值，因此，也就不会对其他的引用有什么影响。
 * <p>
 * 不可变性会带来一定的效率问题。
 */
public class Concatenation {

    public static void main(String[] args) {
        String mango = "mango";
        /*
            会产生一大堆需要垃圾回收的中间对象，性能相当糟糕。
            这也是软件设计中的一个教训，除非你用代码实现将系统实现，并让它动起来，否则你无法真正了解它会有什么问题。
         */
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }

}