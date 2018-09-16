package org.lhqz.demo.thinkinginjava.ploymorphism;

import static org.lhqz.demo.tools.Print.println;

class AlertStatus {
    public void act() {
    }
}

class AlertStatus1 extends AlertStatus {
    @Override
    public void act() {
        println("AlertStatus1");
    }
}

class AlertStatus2 extends AlertStatus {
    @Override
    public void act() {
        println("AlertStatus2");
    }
}

class AlertStatus3 extends AlertStatus {
    @Override
    public void act() {
        println("AlertStatus3");
    }
}

class Status {
    private AlertStatus alertStatus = new AlertStatus1();

    public void change() {
        alertStatus = new AlertStatus2();
    }

    public void performPlay() {
        alertStatus.act();
    }
}

public class Starship {
    public static void main(String[] args) {
        Status status = new Status();
        status.performPlay();
        status.change();
        status.performPlay();
    }
}