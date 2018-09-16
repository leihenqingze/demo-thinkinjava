package org.lhqz.demo.thinkinginjava.interfaces;

interface Monster {
    void menace();
}

/**
 * 接口可以继承接口，扩展新方法
 */
interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class Dragon2illa implements DangerousMonster {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

/**
 * 可以同时继承多个接口
 * 在打算组合的不同接口中使用相同的方法名通常会造成代码可读性的混乱，尽量避免这种情况。
 */
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}

public class HorrorShow {

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new Dragon2illa();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }

}
