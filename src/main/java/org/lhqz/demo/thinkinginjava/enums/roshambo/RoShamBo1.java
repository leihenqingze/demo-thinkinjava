package org.lhqz.demo.thinkinginjava.enums.roshambo;

import static org.lhqz.demo.tools.Print.*;

import java.util.Random;

interface Item {
    Outcome compete(Item it);

    Outcome eval(Paper it);

    Outcome eval(Scissors it);

    Outcome eval(Rock it);
}

class Paper implements Item {

    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper it) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissors it) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock it) {
        return Outcome.LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {

    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper it) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Scissors it) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Rock it) {
        return Outcome.WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {

    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper it) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Scissors it) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Rock it) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}

public class RoShamBo1 {

    static final int SIZE = 20;

    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }

}
