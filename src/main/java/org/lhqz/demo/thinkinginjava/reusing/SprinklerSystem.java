package org.lhqz.demo.thinkinginjava.reusing;

/**
 * 正如Java中所有事物一样，问题解决都是围绕着类展开的。可以通过创建新类来复用代码，
 * 而不必再从头开始编写。可以使用别人业已开发并调试好的类。
 * 此方法的窍门在于使用类而不破坏现有程序的代码。
 * <p>
 * 1.组合:只需要在新的类中产生现有类的对象。该方法只是复用了现有程序代码的功能，而非它的形式。
 * 2.继承:它按照现有类的类型来创建新类。无需改变现有类的形式，采用现有类的形式并在其中添加新代码。
 * (编译器可以完成其中大部分工作)
 * 组合和继承，其语法和行为大多是相似的。由于它们是利用现有类型生成新类型，所以这样做极富意义。
 */

class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    //每个非基本类型都有一个toString()方法
    @Override
    public String toString() {
        return s;
    }
}

public class SprinklerSystem {

    //对象引用初始化为null
    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();
    //基本类型初始化为0值
    private int i;
    private float f;

    @Override
    public String toString() {
        return "value1 = " + value1 + " " +
                "value2 = " + value2 + " " +
                "value3 = " + value3 + " " +
                "value4 = " + value4 + "\n" +
                "i = " + i + " " +
                "f = " + f + " " +
                //WaterSource对象的toString方法自动被调用
                "source = " + source;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }

}
