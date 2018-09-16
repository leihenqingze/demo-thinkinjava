package org.lhqz.demo.thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.lhqz.demo.tools.Print.*;

public class AtomicityTest implements Runnable {

    private int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void m33ain(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                println(val);
                System.exit(0);
            }
        }
    }

}