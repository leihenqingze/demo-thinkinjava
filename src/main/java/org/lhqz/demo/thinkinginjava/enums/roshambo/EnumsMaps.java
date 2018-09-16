package org.lhqz.demo.thinkinginjava.enums.roshambo;

import static org.lhqz.demo.tools.Print.*;

import org.lhqz.demo.thinkinginjava.enums.enumerated.AlarmPoints;

import static org.lhqz.demo.thinkinginjava.enums.enumerated.AlarmPoints.*;

import java.util.EnumMap;
import java.util.Map;

interface Command {
    void action();
}

public class EnumsMaps {

    public static void main(String[] args) {
        Map<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, () -> println("Kitchen fire!"));
        em.put(BATHROOM, () -> println("Bathroom alert!"));
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            print(e.getKey() + ": ");
            e.getValue().action();
        }
        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            println(e);
        }
    }

}