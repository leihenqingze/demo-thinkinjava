package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Mutt",
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pug",
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.EgyptianMau",
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Manx",
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Cymric",
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Rat",
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Mouse",
            "org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Hamster"
    };

    private static void loader() {

        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

}
