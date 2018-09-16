package org.lhqz.demo.thinkinginjava.containers;

import org.lhqz.demo.thinkinginjava.arrays.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

import static org.lhqz.demo.tools.Print.*;

public class QueueBehavior {

    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < count; i++) {
            queue.offer(gen.next());
        }
        while (queue.peek() != null) {
            print(queue.remove() + " ");
        }

        println();
    }

    static class Gen implements Generator<String> {
        String[] s = ("one two three four five six seven " + "eight nine ten").split(" ");
        int i;

        @Override
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
        test(new ArrayBlockingQueue(count), new Gen());
        test(new ConcurrentLinkedDeque(), new Gen());
        test(new LinkedBlockingDeque(), new Gen());
        test(new PriorityBlockingQueue(), new Gen());
    }

}