package StrategyDesignPattern.FlyStrategies;

public class FlyWithSuit implements FlyStrategy{
    @Override
    public String fly(){
        return "power of suit";
    }
}
