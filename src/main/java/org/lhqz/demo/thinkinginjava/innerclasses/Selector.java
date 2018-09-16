package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * 因为这是一个接口，所有别的类可以按它们自己的方式来实现这个接口，
 * 并且别的方法能以此接口为参数，来生成更加通用的代码。
 */
public interface Selector {

    boolean end();

    Object current();

    void next();

}