package org.lhqz.demo.thinkinginjava.holding.container;

import org.lhqz.demo.thinkinginjava.arrays.Generator;
import org.lhqz.demo.thinkinginjava.containers.CollectionData;

import java.util.*;

import static org.lhqz.demo.tools.Print.*;

public class MovieGenerator implements Generator<String> {

    private String[] movies = {"A", "B"};

    private int index;

    @Override
    public String next() {
        String movie = movies[index % 2];
        index++;
        return movie;
    }

    public static void main(String[] args) {
        Generator generator = new MovieGenerator();
        println(new ArrayList<>(CollectionData.list(generator, 10)));
        println(new LinkedList<>(CollectionData.list(generator, 10)));
        println(new HashSet<>(CollectionData.list(generator, 10)));
        println(new LinkedHashSet<>(CollectionData.list(generator, 10)));
        println(new TreeSet<>(CollectionData.list(generator, 10)));
    }

}
