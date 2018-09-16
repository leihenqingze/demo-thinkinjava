package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Dog extends Pet {

    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog";
    }

}
