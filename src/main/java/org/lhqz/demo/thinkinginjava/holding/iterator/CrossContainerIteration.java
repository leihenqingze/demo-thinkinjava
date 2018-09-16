package org.lhqz.demo.thinkinginjava.holding.iterator;

import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pet;
import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pets;

import java.util.*;

import static org.lhqz.demo.tools.Print.println;

public class CrossContainerIteration {

    public static void display(Iterator<Pet> it){
        while (it.hasNext()){
            Pet p = it.next();
            println(p.id() + ":" + p + " ");
        }
        println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }

}