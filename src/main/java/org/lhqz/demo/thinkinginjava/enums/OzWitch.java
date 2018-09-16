package org.lhqz.demo.thinkinginjava.enums;

import static org.lhqz.demo.tools.Print.*;

/**
 * 基本上可以将enum看作一个常规的类，可以添加新方法，可以有main方法
 */
public enum OzWitch {

    WEST("west"),
    NORTH("north"),
    EAST("east"),
    SOUTH("south");

    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            println(witch + ": " + witch.getDescription());
        }
    }

}