package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

import static org.lhqz.demo.tools.Print.*;

public class PetCount4 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            println(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
    }

}
