package org.lhqz.demo.thinkinginjava.initialization.thises;

public class ThisTest2 {

    public ThisTest2(){

    }

    public ThisTest2(String s){
        this();
    }

    public static void main(String[] args) {
        ThisTest2 thisTest = new ThisTest2();
    }

}
