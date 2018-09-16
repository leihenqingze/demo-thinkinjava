package org.lhqz.demo.thinkinginjava.holding.queue;

import java.util.Queue;

import static org.lhqz.demo.tools.Print.*;

public class CommandConsume {

    public static void main(String[] args) {
        CommandQueue commandQueue = new CommandQueue();
        Queue<Command> queue = commandQueue.fill(10);
        while (null != queue.peek()){
            println(queue.remove().getOperation());
        }
        println();
    }

}