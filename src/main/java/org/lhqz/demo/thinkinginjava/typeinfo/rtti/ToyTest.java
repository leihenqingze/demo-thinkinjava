package org.lhqz.demo.thinkinginjava.typeinfo.rtti;

import static org.lhqz.demo.thinkinginjava.util.Print.*;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        //类的全限定名，是否表示一个接口
        print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        //不包含包名
        print("Simple name: " + cc.getSimpleName());
        //类的全限定名
        print("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            //使用全限定名
            c = Class.forName("org.lhqz.demo.thinkinginjava.typeinfo.rtti.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(c);

        //返回Class对象中所包含的接口
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        //查找直接基类
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //创建类的对象，该类必须有默认构造器
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

}