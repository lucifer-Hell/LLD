package StrategyDesignPattern;

import StrategyDesignPattern.FlyStrategies.FlyStrategy;
import StrategyDesignPattern.FlyStrategies.FlyWithMagic;

public class DrStrange extends Hero{

    DrStrange() {
        super(new FlyWithMagic());
    }
}
