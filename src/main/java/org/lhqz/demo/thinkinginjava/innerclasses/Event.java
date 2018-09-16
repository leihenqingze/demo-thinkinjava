package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * 应用程序框架：就是被设计用以解决某些特定问题的一个类或一组类。
 * 要运用某个应用程序框架，通常是继承一个或多个类，并覆盖某些方法。在覆盖后的方法中，
 * 编写代码定制应用程序提供的通用解决方案，以解决你的特定问题(这是模版方法的一个例子)。
 * 模版方法：包含算法的基本结构，并且会调用一个或多个可覆盖的方法，以完成算法的动作。
 * 设计模式总是将变化的事物与保持不变的事物分离开，在这个模式中，模版方法是保持不变的事物，
 * 而可覆盖的方法就是变化的事物。
 * <p>
 * 控制框架是一类特殊的应用程序框架，它用来解决响应时间的需求。主要用来响应事件的系统被称作事件驱动系统。
 * GUI
 */

public abstract class Event {

    /**
     * 事件触发时间
     */
    private long eventTime;
    protected final long dealyTime;

    public Event(long dealyTime) {
        this.dealyTime = dealyTime;
        start();
    }

    /**
     * 独立的方法，没有在构造器中，这样可以在事件运行以后重新启动记时器，
     * 也就是能够重复使用Event对象。
     */
    public void start() {
        //对象创建时间+延迟时间
        eventTime = System.nanoTime() + dealyTime;
    }

    /**
     * 可以在子类中覆盖，使得Event能够基于时间以外的其他因素而触发。
     */
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();

}