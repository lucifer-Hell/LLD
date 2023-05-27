package StrategyDesignPattern;

import StrategyDesignPattern.FlyStrategies.FlyWithMagic;

public class Thor extends Hero{
    Thor() {
        super(new FlyWithMagic()); // avoding code duplicay for thor and dr strange
    }
}
