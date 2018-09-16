package org.lhqz.demo.thinkinginjava.holding.generics;

import static org.lhqz.demo.tools.Print.*;

import java.util.ArrayList;
import java.util.Iterator;

class Gerbil {
    private static long counter;
    private final long gerbilNumber = counter++;

    long hop() {
        return gerbilNumber;
    }
}

public class GerbilPrint {

    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new Gerbil());
        }
        for (Gerbil gerbil : gerbils) {
            println(gerbil.hop());
        }
        Iterator<Gerbil> iterator = gerbils.iterator();
        while (iterator.hasNext()) {
            println(iterator.next().hop());
        }
    }

}