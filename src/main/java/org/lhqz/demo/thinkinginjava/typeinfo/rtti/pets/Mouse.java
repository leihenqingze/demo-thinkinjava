package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Mouse extends Rodent {

    public Mouse() {
        super();
    }

    public Mouse(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Mouse";
    }

}
