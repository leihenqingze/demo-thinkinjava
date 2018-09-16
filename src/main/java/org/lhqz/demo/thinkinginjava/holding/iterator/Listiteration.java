package org.lhqz.demo.thinkinginjava.holding.iterator;

import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pet;
import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pets;

import java.util.List;
import java.util.ListIterator;

import static org.lhqz.demo.tools.Print.*;

/**
 * 双向移动
 * 前后指针
 */
public class Listiteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        println();
        while (it.hasPrevious()) {
            print(it.previous().id() + " ");
        }
        println();
        println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()){
            it.next();
            it.set(Pets.randomPet());
        }
        println(pets);
    }

}
