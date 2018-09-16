package org.lhqz.demo.thinkinginjava.holding.iterator;

import static org.lhqz.demo.tools.Print.*;

import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pet;
import org.lhqz.demo.thinkinginjava.typeinfo.rtti.pets.Pets;

import java.util.*;

/**
 * 使用接口描述的一个理由是它可以是我们能够创建更通用的代码，通过针对接口而非具体实现类编写代码，
 * 我们的代码可以应用于更多的对象类型。因此，如果我编写的方法将接受一个Collection，
 * 那么该方法就可以应用于任何实现了Collection的类——这也就使得一个新类可以选择去实现Collection接口，
 * 以便我的方法可以使用它。
 * Java也用迭代器表示容器直接的共性。但是两种方式绑定到了一起，因为实现Collection就需要提供iterator()方法
 */
public class InterfaceVsIterator {

    static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            print(p.id() + ":" + p + " ");
        }
        println();
    }

    static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            print(p.id() + ":" + p + " ");
        }
        println();
    }

    public static void main(String[] args) {
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<>();
        String[] names = ("Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy").split(", ");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i], petList.get(i));
        }
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        display(petList);
        println(petMap);
        println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }

}
