package org.lhqz.demo.thinkinginjava.innerclasses;

class WithInner2 {
    class Inner {
        private String name;

        public Inner(String name) {
            this.name = name;
        }
    }
}

public class InheritInner2 extends WithInner2.Inner {

    InheritInner2(WithInner2 wi, String name) {
        wi.super(name);
    }

    public static void main(String[] args) {
        WithInner2 wi = new WithInner2();
        InheritInner2 ii = new InheritInner2(wi, "zs");
    }

}
