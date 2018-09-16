package org.lhqz.demo.thinkinginjava.enums;

import static org.lhqz.demo.tools.Print.*;

enum Signal {GREEN, YELLOW, RED}

/**
 * enum可以用在switch中
 * <p>
 * 可以没有default:语句，可以少一些case，必须自己确保覆盖了所有的分支。
 * 如果在case语句中调用了return，则必须有default:语句，这与是否覆盖了enum的所有实例无关。
 */
public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            //可以不用指定具体的enum类名
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;

        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            println(t);
            t.change();
        }
    }
}
