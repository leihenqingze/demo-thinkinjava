package org.lhqz.demo.thinkinginjava.interfaces.music4;

import static org.lhqz.demo.tools.Print.*;

/**
 * 接口和内部类为我们提供了一种将接口与实现分离的更加结构化的方法。
 * <p>
 * 尽管在构建具有某些未实现方法的类时，第一想法可能是创建接口，
 * 但是抽象类仍旧是用于此目的的一种重要而必须的工具，因此不可能总是使用纯接口。
 * <p>
 * 用一个类建立一个通用的接口，使不同的子类可以用不同的方法表示此接口。
 * 通用接口建立起了一种基本形式，以此表示所有导出类的共同部分。或者说该类是抽象基类。
 * <p>
 * 如果只有一个像这样的抽象类，那么该类的对象几乎没有任何意义。创建抽象类是希望通过这个通用接口操纵一系列类。
 * 该类只是表示了一个接口，没有具体的实现内容。
 * 因此，创建一个该类的对象没有什么意义，并且可能还想阻止使用者这样做。通过让该类中的所有方法都产生错误，就可以实现这个目的。
 * 但是这样做会将错误信息延迟到运行时才获得，并且需要在客户端进行可靠、详尽的测试。所以最好是在编译时捕获这些问题。
 * <p>
 * Java 提供抽象方法的机制，这种方法使不完整的；仅有声明而没有方法体。
 * abstract void f();
 * <p>
 * 包含抽象方法的类叫做抽象类。如果一个类包含一个或多个抽象方法，该类必须被限定为抽象的。
 * <p>
 * 不可以创建抽象类的对象。
 * <p>
 * 如果从一个抽象类继承，并想创建该新类的对象，那么就必须为基类中的所有抽象方法提供方法的定义。
 * 如果不这样做，那么导出类便也是抽象类，且编译器将会强制用abstract关键字来限定这个类。
 * <p>
 * 也可能会需要创建一个没有任何抽象方法的抽象类。如：如果一个类，让其包含任何abstract方法都显得没有实际意义，
 * 而且也想要阻止产生这个类的任何对象，那么这样就很有用了。
 * <p>
 * 既然使某些类成为抽象类并不需要所有的方法都是抽象的，所以仅需要将某些方法声明为抽象的即可。
 * <p>
 * 创建抽象类和抽象方法非常有用，因为它们可以使类的抽象性明确起来，并告诉用户和编译器打算怎样来使用它们。
 * 抽象类还是很有用的重构工具，因为它们使得我们可以很容易地将公共方法沿着继承层次结构向上移动。
 * <p>
 * <p>
 * 抽象类
 * 抽象类是为了提供一种抽象机制，建立起一个通用的接口，
 * 以此表示所有导出类的共同部分，使不同的子类可以用不同的方法表示此接口
 * <p>
 * 抽象类可以包含0~n个抽象方法。
 * 包含抽象方法的类必须使抽象的。
 * 抽象类可以包含普同方法。
 * 创建抽象类的对象没有什么意义。
 * 编译器保证抽象类的正确型。
 */

enum Note {
    MIDDLE_C
}

abstract class Instrument {
    private int i;

    public abstract void play(Note n);

    public String what() {
        return "Instrument";
    }

    public abstract void adjust();
}

class Wind extends Instrument {
    @Override
    public void play(Note n) {
        println("Wind.play() " + n);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {

    }
}

class Precussion extends Instrument {
    @Override
    public void play(Note n) {
        println("Precussion.play() " + n);
    }

    @Override
    public String what() {
        return "Precussion";
    }

    @Override
    public void adjust() {

    }
}

class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        println("Stringed.play() " + n);
    }

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {

    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        println("Brass.play() " + n);
    }

    @Override
    public void adjust() {
        println("Brass.adjust()");
    }
}

class WoodWind extends Wind {
    @Override
    public void play(Note n) {
        println("WoodWind.play() " + n);
    }

    @Override
    public String what() {
        return "WoodWind";
    }
}

public class Music4 {

    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Precussion(),
                new Stringed(),
                new Brass(),
                new WoodWind()
        };
        tuneAll(orchestra);
    }

}