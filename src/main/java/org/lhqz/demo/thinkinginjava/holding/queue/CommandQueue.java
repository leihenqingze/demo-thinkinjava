package org.lhqz.demo.thinkinginjava.holding.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class CommandQueue {

    Queue<Command> fill(Integer size) {
        Random random = new Random(47);
        Queue<Command> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            queue.offer(new Command(random.nextInt(i + 10) + " "));
        }
        return queue;
    }

}