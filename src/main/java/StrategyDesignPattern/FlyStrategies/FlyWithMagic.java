package StrategyDesignPattern.FlyStrategies;

public class FlyWithMagic implements FlyStrategy{

    @Override
    public String fly() {
        return " power of magic ";
    }
}
