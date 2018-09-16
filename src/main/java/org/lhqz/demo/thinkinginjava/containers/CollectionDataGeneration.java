package org.lhqz.demo.thinkinginjava.containers;

import org.lhqz.demo.thinkinginjava.arrays.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

import static org.lhqz.demo.tools.Print.*;

public class CollectionDataGeneration {

    public static void main(String[] args) {
        println(new ArrayList<String>(
                CollectionData.list(
                        new RandomGenerator.String(9), 10)));
        println(new HashSet<Integer>(
                new CollectionData(
                        new RandomGenerator.Integer(), 10)));
    }

}
