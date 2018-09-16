package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Rodent extends Pet {

    public Rodent() {
        super();
    }

    public Rodent(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Rodent";
    }

}