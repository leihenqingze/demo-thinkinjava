package org.lhqz.demo.thinkinginjava.innerclasses;

public class Outer {

    private String name;

    class Inner {

        @Override
        public String toString() {
            return name;
        }
    }

    public Outer(String name){
        this.name = name;
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("zs");
        Outer.Inner inner = outer.inner();
        System.out.println(inner);
    }

}
