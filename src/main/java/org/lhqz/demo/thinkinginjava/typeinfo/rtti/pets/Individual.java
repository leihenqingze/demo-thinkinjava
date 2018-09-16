package org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets;

public class Individual implements Comparable<Individual> {

    private static Integer count = 0;

    private Integer id;

    public Individual() {
        id = count++;
    }

    public Integer id() {
        return id;
    }

    public Individual(String name) {

    }

    @Override
    public int compareTo(Individual o) {
        return this.id - o.id;
    }
}
