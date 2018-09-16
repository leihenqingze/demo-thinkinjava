package org.lhqz.demo.thinkinginjava.holding.queue;

import java.util.*;

/**
 * 值越小优先级越高
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        Queue<String> stringPQ = new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);

        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            charSet.add(c);
        }
        Queue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);

        Queue<Double> doublePriorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            doublePriorityQueue.offer(rand.nextDouble());
        }
        QueueDemo.printQ(doublePriorityQueue);

        //自定义的类需要实现Comparable接口
        Queue<SimpleObject> simpleObjects = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            simpleObjects.offer(new SimpleObject());
        }
        QueueDemo.printQ(simpleObjects);
    }

}
