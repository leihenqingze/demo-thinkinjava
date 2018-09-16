package org.lhqz.demo.thinkinginjava.reusing;

class A3 {
    private String label;

    public A3() {

    }

    public A3(String label) {
        this.label = label;
    }
}


class C3 extends A3 {
    private B2 b;

    public C3(String label) {
        super(label);
    }
}

public class Demo3 {

    public static void main(String[] args) {
        C2 c = new C2("c");
    }

}
