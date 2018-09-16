package org.lhqz.demo.thinkinginjava.enums;

import static org.lhqz.demo.tools.Print.*;

enum Activity {SITTING, LYING, STANDING, HDPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING}

public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            println(Enums.random(Activity.class) + " ");
        }
    }

}
