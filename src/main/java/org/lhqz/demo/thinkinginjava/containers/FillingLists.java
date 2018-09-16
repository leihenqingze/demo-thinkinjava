package org.lhqz.demo.thinkinginjava.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.lhqz.demo.tools.Print.*;

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        //Object.toString() 类名 + 对象的散列码的无符号十六进制表示(hashCode()生成的)
        return super.toString() + " " + s;
    }
}

public class FillingLists {

    public static void main(String[] args) {
        //所有引用都指向相同的对象
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello")));
        println(list);
        //所有引用都指向相同的对象，只可以替换以存在的元素，而不能添加新的元素
        Collections.fill(list, new StringAddress("World!"));
        println(list);
    }

}
