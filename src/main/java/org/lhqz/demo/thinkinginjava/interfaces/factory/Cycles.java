package org.lhqz.demo.thinkinginjava.interfaces.factory;

interface Cycle {
    boolean cycle();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {

    @Override
    public boolean cycle() {
        return false;
    }
}

class UnicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {

    @Override
    public boolean cycle() {
        return false;
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {

    @Override
    public boolean cycle() {
        return false;
    }
}

class TricycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class Cycles {

    public static void cycle(CycleFactory factory) {
        Cycle s = factory.getCycle();
        s.cycle();
    }

    public static void main(String[] args) {
        cycle(new UnicycleFactory());
        cycle(new BicycleFactory());
        cycle(new TricycleFactory());
    }

}
