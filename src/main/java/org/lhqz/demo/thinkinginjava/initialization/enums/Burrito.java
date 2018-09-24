package org.lhqz.demo.thinkinginjava.initialization.enums;

/**
 * 编译器会将enum编译为类，并且具有自己的方法。
 * 在很大程度上，可以将enum当作其他任何类来处理。
 * 可以在switch语句内使用。
 * 由于switch是要在有限的可能值集合重进行选择，因此它与enum正是绝佳的组合。
 * 请注意enum的名字是如何能够加倍清楚地表明程序意欲何为的。
 * 大体上，可以将enum用作另外一种创建数据类型的方式，然后直接将所得到的类型拿来使用。
 * 这正是关键所在，因此你不必过多地考虑它们。
 * 在Java SE5引进enum之前，你必须花费大量的精力去保证与其等价的枚举类型是安全可用的。
 */
public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        System.out.println("This burrito is ");
        switch (degree) {
            case HOT:
                System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot.");
                break;
            case NOT:
            case FLAMING:
            default:
                System.out.println("maybe too not.");
        }
    }

    public static void main(String[] args) {
        Burrito plain = new Burrito(Spiciness.NOT),
                greenChile = new Burrito(Spiciness.MEDIUM),
                jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}