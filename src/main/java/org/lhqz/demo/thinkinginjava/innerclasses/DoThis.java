package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * OuterClassName.this
 * 生成对外部类对象的引用。
 * 这样产生的引用自动地具有正确的类型，在编译期就被知晓并受到检查，因此没有任何运行时开销。
 */
public class DoThis {

    void f() {
        System.out.println("DoThis.f()");
    }

    public class Inner {
        public DoThis outer() {
            return DoThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DoThis dt = new DoThis();
        DoThis.Inner dti = dt.inner();
        dti.outer().f();
    }

}