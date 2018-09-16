package org.lhqz.demo.thinkinginjava.enums;

import static org.lhqz.demo.tools.Print.*;

import org.lhqz.demo.thinkinginjava.enums.enumerated.AlarmPoints;

import java.util.EnumSet;

public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);    // Empty set
        points.add(AlarmPoints.BATHROOM);
        println(points);
        points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        println(points);
        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        println(points);
        points = EnumSet.complementOf(points);
        println(points);
    }

}
