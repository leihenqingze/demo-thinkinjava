package org.lhqz.demo.thinkinginjava.holding.list;

import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.*;

import java.util.*;

import static org.lhqz.demo.tools.Print.*;

public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
        println(pets);
        println("pets.getFirst():" + pets.getFirst());
        println("pets.element():" + pets.element());
        println("pets.peek():" + pets.peek());
        println("pets.remove():" + pets.remove());
        println("pets.removeFirst():" + pets.removeFirst());
        println("pets.poll():" + pets.poll());
        println(pets);
        pets.addFirst(new Rat());
        println("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        println("After offer():" + pets);
        pets.add(Pets.randomPet());
        println("After add():" + pets);
        pets.addLast(new Hamster());
        println("After addLast():" + pets);
        println("pets.removeLast():" + pets.removeLast());
    }

}