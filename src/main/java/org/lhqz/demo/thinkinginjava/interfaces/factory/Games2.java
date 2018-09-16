package org.lhqz.demo.thinkinginjava.interfaces.factory;

import static org.lhqz.demo.tools.Print.println;

/**
 * 确定接口是理想选择，因而应该总是选择接口而不是具体的类。这其实是一种引诱。
 * 当然，对于创建类，几乎在任何时刻，都可以替代为创建一个接口和一个工厂。
 * <p>
 * 许多人都掉进了这种诱惑的陷阱，只要有可能就去创建接口和工厂。这种逻辑看起来好像是因为需要使用不同的具体实现，
 * 因此总是应该添加这种抽象性。这实际上已经变成了一种草率的设计优化。
 * <p>
 * 任何抽象性都应该是应真正的需求而产生的。当必需时，你应该重构接口而不是到处添加额外级别的间接性，并由此带来的额外的复杂性。
 * 这种额外的复杂性非常显著，如果你让某人去处理这种复杂性，只是因为你意识到由于以防万一而添加了新接口，而没有其他更有说服力的原因，
 * 那么好吧，如果我碰上了这种事，那么就会质疑此人所作的所有设计了。
 * <p>
 * 恰当的原则应该是优先选择类而不是接口。从类开始，如果接口的必需性变得非常明确，那么就进行重构。
 * 接口是一种重要的工具，但是它们容易被滥用。
 */
class Coin implements Game {

    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class CoinFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Coin();
    }
}

class Dicing implements Game {

    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class DicingFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Dicing();
    }
}

public class Games2 {

    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move()) ;
    }

    public static void main(String[] args) {
        playGame(new CoinFactory());
        playGame(new DicingFactory());
    }

}
