package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * 继承另一个类的内部类
 * <p>
 * 因为内部类的构造器必须连接到指向其外围类对象的引用。
 * 问题在于，那个指向外围类对象的"秘密"引用必须被初始化，而在导出类中不再存在可连接的默认对象。
 * 要解决这个问题，构造器必须传递一个指向外围类对象的引用，并且必须在构造器内使用如下语法：
 * enclosingClassReference.super();
 * 这样才提供了必要的引用，然后程序才能编译通过。
 */

class WithInner {
    class Inner {
    }
}

public class InheritInner extends WithInner.Inner {

    InheritInner(WithInner wi) {
        //调用的是内部类的构造器
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }

}
