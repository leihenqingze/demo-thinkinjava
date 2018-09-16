package org.lhqz.demo.thinkinginjava.enums;

import org.lhqz.demo.tools.OSExecute;

import static org.lhqz.demo.tools.Print.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore {HERE, THERE}

/**
 * values() valueOf()由编译器生成
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        println("----- Analyzing " + enumClass + " -----");
        println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            println(t);
        }

        println("Base: " + enumClass.getSuperclass());
        println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        println("Explore.removeAll(Enum)? " + exploreMethods.removeAll(enumMethods));
        println(exploreMethods);
        OSExecute.command("javap Explore");
    }

}
