package org.lhqz.demo.thinkinginjava.enums;

import static org.lhqz.demo.tools.Print.*;

enum Search {HITHER, YON}

public class UpcastEnum {

    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum<Search> e = Search.HITHER;
        //e.values(); //No values() in enum
        for (Enum<Search> en : e.getClass().getEnumConstants()) {
            println(en);
        }
    }

}
