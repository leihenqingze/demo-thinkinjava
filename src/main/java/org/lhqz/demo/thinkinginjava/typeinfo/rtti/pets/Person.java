package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Person extends Individual {

    public Person() {
        super();
    }

    public Person(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Person";
    }

}
