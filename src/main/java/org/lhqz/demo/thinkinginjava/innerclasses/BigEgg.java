package org.lhqz.demo.thinkinginjava.innerclasses;

import static org.lhqz.demo.tools.Print.*;

/**
 * 当某个类继承了另一个类，并定义了与父类的同名的内部类，子类并不会覆盖分类的内部类。
 * 这两个内部类是完全独立的两个实体，各自在自己的命名空间内。
 */
class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            println("Egg.Yolk");
        }
    }

    public Egg() {
        println("New Egg()");
        y = new Yolk();
    }

}

public class BigEgg extends Egg {

    public class Yolk {
        public Yolk() {
            println("BigEgg.Yolk");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }

}