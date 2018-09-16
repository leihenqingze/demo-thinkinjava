package org.lhqz.demo.thinkinginjava.holding.list;

import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.*;

import java.util.*;

import static org.lhqz.demo.tools.Print.*;

/**
 * List:承诺可以将元素维护在特定的序列中
 * ArrayList:随机访问较快，中间插入和删除元素较慢
 * LinkedList:中间插入和删除操作较快，提供了优化的顺序访问，随机访问较慢
 */
public class ListFeatures {

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        println("1: " + pets);
        Hamster h = new Hamster();
        pets.add(h);
        println("2: " + pets);
        //依赖于equals()
        println("3: " + pets.contains(h));
        //依赖于equals()
        pets.remove(h);
        Pet p = pets.get(2);
        println("4: " + p + " " + pets.indexOf(p));
        Pet cymric = new Cymric();
        //依赖于equals()
        println("5: " + pets.indexOf(cymric));
        println("6: " + pets.remove(cymric));
        println("7: " + pets.remove(p));
        println("8: " + pets);
        pets.add(3, new Mouse());
        println("9: " + pets);
        //判断，对子集合修改会反映到原集合
        List<Pet> sub = pets.subList(1, 4);
        println("subList: " + sub);
        println("10: " + pets.containsAll(sub));
        Collections.sort(sub);
        println("sorted subList: " + sub);
        //不考虑元素的顺序
        println("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand);
        println("shuffle subList: " + sub);
        println("12: " + pets.containsAll(sub));
        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        println("sub: " + sub);
        //交集，依赖于equals()
        copy.retainAll(sub);
        println("13: " + copy);
        copy = new ArrayList<>(pets);
        copy.remove(2);
        println("14: " + copy);
        copy.removeAll(sub);
        println("15: " + copy);
        //修改指定位置的元素
        copy.set(1, new Mouse());
        println("16: " + copy);
        //插入到指定位置
        copy.addAll(2, sub);
        println("17: " + copy);
        println("18: " + copy.isEmpty());
        pets.clear();
        println("19: " + pets);
        println("20: " + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        println("21: " + pets);
        Object[] o = pets.toArray();
        println("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        println("23: " + pa[3].id());
    }

}