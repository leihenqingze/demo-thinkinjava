package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * 当将内部类向上转型为其基类，尤其是转型为一个接口的时候，内部类就有用了。
 * 这样使的某个接口的实现能够完全不可见，并且不可用，所得到的只是指向基类或接口的引用，所以能够很方便地隐藏实现细节。
 * 当取的了一个指向基类或接口的引用时，甚至可能无法找出它确切的类型。
 */
public class Parcel4 {

    /**
     * 如果客户端程序员想了解或访问这些成员，那是要受到限制的。甚至不能向下转型为private内部类。
     * 因为不能访问其名字，于是，private内部类给类的设计者提供了一种途径，通过这种方式可以完全阻止依赖于类型的编码，
     * 并且完全隐藏了实现的细节。此外，从客户端程序元的角度来看，由于不能访问任何新增加的、原本不属于公共接口的方法，
     * 所以扩展接口是没有价值。这也给Java编译器提供了生成更高效代价的机会。
     */
    private class PContents implements Contents {
        /**
         * 外部类不能方位内部类的私有成员
         */
        private int i = 11;

        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        PDestination(String whereTo) {
            label = whereTo;
        }


        @Override
        public String readLine() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        PContents contents = new PContents();
        return new PContents();
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
    }

}
