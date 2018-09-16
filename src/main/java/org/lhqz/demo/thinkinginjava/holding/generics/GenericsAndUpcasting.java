package org.lhqz.demo.thinkinginjava.holding.generics;

import static org.lhqz.demo.tools.Print.*;

import java.util.ArrayList;

class GrannySmith extends Apple {
}

class Gala extends Apple {
}

class Fuji extends Apple {
}

class Braeburn extends Apple {
}

public class GenericsAndUpcasting {

    public static void main(String[] args) {
        //可以添加子类型
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple c : apples) {
            println(c);
        }
    }

}
