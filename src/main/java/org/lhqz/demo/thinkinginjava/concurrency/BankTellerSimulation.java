package org.lhqz.demo.thinkinginjava.concurrency;

/**
 * 通过使用并发，仿真的每个构件都可以成为其自身的任务，这使得仿真更容易编程
 * <p>
 * 银行出纳员仿真：对象随机地出现，并且要求由数量有限的服务器提供随机数量的服务时间。
 * 通过构建仿真可以确定理想的服务器数量
 */
//Using queues and multithreading

import static org.lhqz.demo.tools.Print.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Read-only objects dont's require synchronized
class Customer {

    private final int serviceTIme;

    public Customer(int tm) {
        serviceTIme = tm;
    }

    public int getServiceTIme() {
        return serviceTIme;
    }

    @Override
    public String toString() {
        return "[" + serviceTIme + "]";
    }
}

// Teach the customer line to display itself
class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for (Customer customer : this) {
            result.append(customer);
        }
        return result.toString();
    }
}

//Randomly add customers to queue:
class CustomerGenerator implements Runnable {

    private CustomerLine customers;

    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine cq) {
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MICROSECONDS.sleep(rand.nextInt(1000));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            println("CustomerGenerator interrupted");
        }
        println("CustomerGenerator terminating");
    }
}

class Teller implements Runnable, Comparable<Teller> {

    private static int counter = 0;

    private final int id = counter++;

    private int customersServed = 0;

    private CustomerLine customers;

    private boolean servingCustomerLine = true;

    public Teller(CustomerLine cq) {
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MICROSECONDS.sleep(customer.getServiceTIme());
                synchronized (this) {
                    customersServed++;
                    while (!servingCustomerLine) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            println(this + "interrupted");
        }
        println(this + "terminating");
    }

    public synchronized void doSomethingElse() {
        customersServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert servingCustomerLine : "already serving:" + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller " + id + " ";
    }

    public String shortString() {
        return "T" + id;
    }

    @Override
    public int compareTo(Teller o) {
        return customersServed < o.customersServed ? -1 : (customersServed == o.customersServed ? 0 : 1);
    }

}

class TellerManager implements Runnable {

    private ExecutorService exec;

    private CustomerLine customers;

    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();

    private int adjustmentPeriod;
    private static Random rand = new Random(47);

    public TellerManager(ExecutorService e, CustomerLine customers, int adjustmentPeriod) {
        this.exec = e;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber() {
        if (customers.size() / workingTellers.size() > 2) {
            if (workingTellers.size() > 0) {
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
            }
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
            reassignOneTeller();
        }
        if (customers.size() == 0) {
            while (workingTellers.size() > 1) {
                reassignOneTeller();
            }
        }
    }

    private void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                println(customers + " { ");
                for (Teller teller : workingTellers) {
                    println(teller.shortString() + " ");
                }
                println("}");
            }
        } catch (InterruptedException e) {
            println(this + "interrupted");
        }
        println(this + "terminating");
    }

    @Override
    public String toString() {
        return "TellerManager ";
    }
}

public class BankTellerSimulation {

    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdown();
    }

}