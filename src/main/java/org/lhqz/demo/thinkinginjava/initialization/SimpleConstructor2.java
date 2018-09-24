package org.lhqz.demo.thinkinginjava.initialization;

/**
 * 用构造器确保初始化
 * <p>
 * 可以假想为编写的每个类中都定义一个initialize()方法，
 * 该方法的名称提醒你在使用其对象之前，应首先调用nitialize()。
 * 然而，这同时意味着用户必需记得自己去调用此方法。
 * 在Java中，通过提供构造器，类的设计者可确保每个对象都会得到初始化。
 * 创建对喜时，如果其类具有构造器，Java就会在用户有能力操作对象之前
 * 自动调用相应的构造器，从而保证了初始化的进行。
 * <p>
 * 构造器的命名
 * <p>
 * 1.所取的任何名字都可能与类的某个成员名称相冲突。
 * 2.调用构造器是编译器的责任，所以必须让编译器知道应该调用那个方法。
 * 所以构造器采用与类相同的名称。
 * <p>
 * 在创建对象时，将会为对象分配存储空间，并调用相应的构造器。
 * 这就确保了在能操作对象之前，它已经被恰当地初始化了。
 * <p>
 * 不接受任何参数的构造器叫默认构造器，和其他方法一样，
 * 构造器也能带有形式参数，以便指定如何创建对象。
 * 有了构造器形式参数，就可以在初始化对象时提供实际参数。
 * <p>
 * 构造器有助于减少错误，并使代码更易于阅读。从概念上讲，"初始化"与"创建"是彼此独立的，
 * Java中，"初始化"和"创建"捆绑在一起，两者不能分离。
 * <p>
 * 构造器是一种特殊类型的方法，因为它没有返回值。这与返回值为空明显不同。
 * 对于空返回值，尽管方法本身不会自动返回什么，但仍可选择让它返回别的东西。
 * 构造器则不会返回任何东西，new表达式返回了对新对象的引用，但构造器本身并没有任何返回值。
 * 如果构造器具有返回值，并且允许人们自行选择返回类型，那么就需要让编译器知道该如何处理此返回值。
 */
class Rock {
    Rock() {
        System.out.println("Rock ");
    }
}

public class SimpleConstructor2 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
        }
    }

}