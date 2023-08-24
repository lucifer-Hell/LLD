package ConceptAndCoding.desginPatterns.StrategyDesignPattern;

import ConceptAndCoding.desginPatterns.StrategyDesignPattern.FlyStrategies.FlyWithMagic;

public class DrStrange extends Hero{

    DrStrange() {
        super(new FlyWithMagic());
    }
}
