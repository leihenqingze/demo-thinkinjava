package org.lhqz.demo.thinkinginjava.reusing;

import static org.lhqz.demo.tools.Print.println;

class InertiaVo {

    private String s;

    InertiaVo() {
        println("InertiaVo()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }

}

class InertiaDemo {

    private InertiaVo inertiaVo;

    @Override
    public String toString() {
        if (null == inertiaVo) {
            inertiaVo = new InertiaVo();
        }
        return inertiaVo.toString();
    }

}

public class Inertia {
    public static void main(String[] args) {
        InertiaDemo inertiaDemo = new InertiaDemo();
        println(inertiaDemo);
    }
}