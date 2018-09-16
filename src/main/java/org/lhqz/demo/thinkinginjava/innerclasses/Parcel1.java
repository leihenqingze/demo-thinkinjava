package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * 它允许把一些逻辑相关的类组织在一起，并控制位于内部类的可视性。
 * 内部类与组合是完全不同的概念。
 */
public class Parcel1 {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLine() {
            return label;
        }
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLine());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }

}
