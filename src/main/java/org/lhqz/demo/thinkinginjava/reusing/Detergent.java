package org.lhqz.demo.thinkinginjava.reusing;

import static org.lhqz.demo.tools.Print.*;

class Cleanser {

    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    //即使不是一个public类，其main仍然是可访问的
    //在命令行中也可以访问
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        println(x);
    }
}

/**
 * 如果没有加任何访问权限修饰词，那么成员默认的访问权限是包访问权限，它允许包内的成员访问。
 * 因此，在此包中，如果没有访问权限修饰词，任何人都可以使用这些方法。
 * 但是，其他包中的某个类若要从父类中继承，则只能访问public成员。
 * 为了继承，一般的规则是将所有的数据成员都指定为private，将所有的方法指定为public。
 * 通过继承，会自动得到基类中所有的域和方法。
 * 可以将继承视作是对类的复用。
 */
public class Detergent extends Cleanser {

    //重写父类方法
    public void scrub() {
        append(" Detergent scrub()");
        //调用父类中的方法，如果不使用super将会产生递归，因为调用的是当前类的方法
        super.scrub();
    }

    //不一定非得使用基类得方法，可以在子类中添加新方法
    public void foam() {
        append(" foam()");
    }

    //明确调用了Cleanser的main()
    public static void main(String[] args) {
        Detergent x = new Detergent();
        //可以调用父类中所有可用的方法
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        println(x);
        println("Testing base class:");
        Cleanser.main(args);
    }

}

class DetergentNew extends Detergent {

    public void scrub() {
        append(" DetergentNew scrub()");
    }

    public void sterilize() {
        append(" sterilize()");
    }
}