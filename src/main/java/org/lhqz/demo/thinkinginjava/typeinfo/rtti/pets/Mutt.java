package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Mutt extends Dog {

    public Mutt() {
        super();
    }

    public Mutt(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Mutt";
    }

}
