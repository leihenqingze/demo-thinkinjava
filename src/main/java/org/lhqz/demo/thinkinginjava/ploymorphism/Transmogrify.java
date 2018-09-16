package org.lhqz.demo.thinkinginjava.ploymorphism;

import static org.lhqz.demo.tools.Print.*;

/**
 * 学习了多态之后，看起来似乎所有东西都可以被继承，因为多态是一种如此巧妙的工具。
 * 事实上，当我们使用现成的类来建立新类时，如果首先考虑使用继承技术，反倒会加重我们的设计负担，使事情变得不必要地复杂起来。
 * 更好的方式是首先选择"组合"，尤其是不能十分确定应该使用哪一种方式时。组合不会强制我们的程序设计进入继承的层次结构中。
 * 而且，组合更加灵活，因为它可以动态选择类型(因此也就选择了行为)，相反，继承在编译时就需要知道确切类型。
 */
class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {
    @Override
    public void act() {
        println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        println("SadActor");
    }
}

class Stage {
    //持有一个父类的对象，初始化为子类对象，这意味着performPlay会产生某种特殊行为
    private Actor actor = new HappyActor();

    public void change() {
        //既然引用在运行时可以与另一个不同的对象重新绑定起来，行为也随之改变
        //这样一来，我们在运行期间获得了动态灵活性(这也称作为状态模式)
        //与此相反，我们不能在运行期间决定继承不同的对象，因为它要求在编译期间完全确定下来。
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

/**
 * 一条通用的准则是:"用继承表达行为间的差异，并用字段表达状态上的变化"
 * 上面通过继承得到了两个不同的类，用于表达act()方法的差异；
 * 而Stage通过运用组合使自己的状态发生变化。
 * 这种情况下，这种状态的改变也就产生了行为的改变。
 */
public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}