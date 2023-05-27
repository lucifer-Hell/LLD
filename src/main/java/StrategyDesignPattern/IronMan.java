package StrategyDesignPattern;

import StrategyDesignPattern.FlyStrategies.FlyWithSuit;

public class IronMan extends Hero{
    IronMan(){
        super(new FlyWithSuit());
    }
}
