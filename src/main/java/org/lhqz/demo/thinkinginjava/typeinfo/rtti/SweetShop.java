package org.lhqz.demo.thinkinginjava.typeinfo.rtti;

import static org.lhqz.demo.tools.Print.*;

class Candy {
    static {
        println("Loading Candy");
    }
}

class Gum {
    static {
        println("Loading Gum");
    }
}

class Cookie {
    static {
        println("Loading Cookie");
    }
}

public class SweetShop {

    public static void main(String[] args) {
        println("inside main");
        new Candy();
        println("After creating Candy");
        try {
            Class.forName("org.lhqz.demo.thinkinginjava.typeinfo.rtti.Gum");
        } catch (ClassNotFoundException e) {
            println("Couldn't find Gum");
        }
        println("After Class.forName(\"Gum\")");
        new Cookie();
        println("After creating Cookie");
    }

}
