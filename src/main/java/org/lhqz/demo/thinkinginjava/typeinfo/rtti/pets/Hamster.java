package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Hamster extends Rodent {

    public Hamster() {
        super();
    }

    public Hamster(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Hamster";
    }

}
