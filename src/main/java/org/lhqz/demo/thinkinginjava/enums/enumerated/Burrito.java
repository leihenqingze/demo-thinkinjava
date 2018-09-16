package org.lhqz.demo.thinkinginjava.enums.enumerated;

/**
 * 静态导入
 * 在默认包中定义enum，这种技巧也无法使用。
 */
public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree){
        this.degree = degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(Spiciness.HOT));
        System.out.println(new Burrito(Spiciness.HOT));
        System.out.println(new Burrito(Spiciness.HOT));
    }

}