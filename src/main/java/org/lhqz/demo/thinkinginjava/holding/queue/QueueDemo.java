package org.lhqz.demo.thinkinginjava.holding.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.lhqz.demo.tools.Print.*;

/**
 * FIFO
 * 事物放入容器的顺序与取出的顺序是相同的
 * 队列常被当作一种可靠的将对象从程序的某个区域传输到另一个区域的途径
 * 队列在并发编程中特别重要，因为它们可以安全地将对象从一个任务传输给另一个任务
 */
public class QueueDemo {

    static void printQ(Queue queue) {
        /*
            peek和element在不移除的情况下返回队头，队列为空时，peek返回null，而element会抛出异常
            poll和remove在移除的情况下返回队头，队列为空时，poll返回null，而remove会抛出异常
         */
        while (null != queue.peek()) {
            print(queue.remove() + " ");
        }
        println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            //在允许的情况下，将一个元素插入到队尾，或者返回false
            queue.offer(rand.nextInt(i + 10));
        }
        printQ(queue);
        Queue<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }

}