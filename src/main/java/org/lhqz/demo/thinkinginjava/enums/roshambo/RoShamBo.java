package org.lhqz.demo.thinkinginjava.enums.roshambo;

import org.lhqz.demo.thinkinginjava.enums.Enums;

import static org.lhqz.demo.tools.Print.*;

interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}

public class RoShamBo {

    public static <T extends Competitor<T>> void match(T a, T b) {
        println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }

}