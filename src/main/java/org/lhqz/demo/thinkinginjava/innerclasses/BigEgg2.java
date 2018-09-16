package org.lhqz.demo.thinkinginjava.innerclasses;

import static org.lhqz.demo.tools.Print.println;

/**
 * 当某个类继承了另一个类，子类中的内部类也可以继承父类的内部类。
 */
class Egg2 {

    protected class Yolk {
        public Yolk() {
            println("Egg2.Yolk");
        }

        public void f() {
            println("Egg2.Yolk.f()");
        }
    }

    private Yolk y = new Yolk();

    public Egg2() {
        println("New Egg2()");
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }

    public void g() {
        y.f();
    }

}

public class BigEgg2 extends Egg2 {

    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            //调用类父类的构造器
            println("BigEgg2.Yolk");
        }

        public void f() {
            println("BigEgg2.Yolk.f()");
        }
    }

    public BigEgg2() {
        //向上转型为了父类
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }

}