package org.lhqz.demo.thinkinginjava.initialization;

class Rock3 {
    private String label;

    Rock3() {
        System.out.println("Rock " + label + " ");
    }
}

public class SimpleConstructor3 {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock3();
        }
    }

}