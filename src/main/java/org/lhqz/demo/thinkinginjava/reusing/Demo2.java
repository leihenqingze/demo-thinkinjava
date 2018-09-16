package org.lhqz.demo.thinkinginjava.reusing;

class A2{
    private String label;

    public A2(String label){
        this.label = label;
    }
}

class B2{
    private String label;

    public B2(String label){
        this.label = label;
    }
}

class C2 extends A2{
    private B2 b;
    public C2(String label){
        super(label);
        b = new B2(label);
    }
}

public class Demo2 {

    public static void main(String[] args) {
        C2 c = new C2("c");
    }

}
