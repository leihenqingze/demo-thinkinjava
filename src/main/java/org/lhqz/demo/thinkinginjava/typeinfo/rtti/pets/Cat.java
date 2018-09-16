package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Cat extends Pet {

    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
