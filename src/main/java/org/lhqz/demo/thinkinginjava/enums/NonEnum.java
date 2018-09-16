package org.lhqz.demo.thinkinginjava.enums;

import static org.lhqz.demo.tools.Print.*;

public class NonEnum {

    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            Integer integer = new Integer(1111);
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception ex) {
            println(ex);
        }
    }

}
