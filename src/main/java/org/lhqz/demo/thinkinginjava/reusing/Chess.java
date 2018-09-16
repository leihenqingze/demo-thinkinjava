package org.lhqz.demo.thinkinginjava.reusing;

import static org.lhqz.demo.tools.Print.*;

class Game {
    Game(int i) {
        println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        //如果没有默认的基类构造器，或者想调用一个带有参数的基类构造器，
        //就必须用关键字super显示地编写调用基类构造器的语句，并且配以适当的参数列表。
        //必须是导出类构造器中要做的第一件事。
        super(i);
        println("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}