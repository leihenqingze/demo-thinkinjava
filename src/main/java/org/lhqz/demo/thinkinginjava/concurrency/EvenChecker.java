package org.lhqz.demo.thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.lhqz.demo.tools.Print.*;

public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        this.generator = g;
        this.id = ident;
    }

    @Override
    public void run() {

        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                println(val + " not even!");
                generator.cancel();
            }
        }

    }

    public static void test(IntGenerator gp, int count) {
        println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

}