package org.lhqz.demo.thinkinginjava.containers.oldcontainers;

import org.lhqz.demo.thinkinginjava.containers.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import static org.lhqz.demo.tools.Print.*;

public class Enumerations {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements()) {
            print(e.nextElement() + ", ");
        }
        e = Collections.enumeration(new ArrayList<>());
    }

}