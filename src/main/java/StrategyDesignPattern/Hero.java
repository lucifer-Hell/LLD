package StrategyDesignPattern;

import StrategyDesignPattern.FlyStrategies.FlyStrategy;

public class Hero {
    private final FlyStrategy flyStrategy;
    Hero(FlyStrategy flyStrategy){
        this.flyStrategy=flyStrategy;
    }
    public void fly(){
        System.out.println("flying with "+this.flyStrategy.fly());
    }
}
