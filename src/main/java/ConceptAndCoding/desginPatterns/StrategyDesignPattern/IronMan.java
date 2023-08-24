package ConceptAndCoding.desginPatterns.StrategyDesignPattern;

import ConceptAndCoding.desginPatterns.StrategyDesignPattern.FlyStrategies.FlyWithSuit;

public class IronMan extends Hero{
    IronMan(){
        super(new FlyWithSuit());
    }
}
