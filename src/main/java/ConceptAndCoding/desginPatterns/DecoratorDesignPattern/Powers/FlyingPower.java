package ConceptAndCoding.desginPatterns.DecoratorDesignPattern.Powers;

import ConceptAndCoding.desginPatterns.DecoratorDesignPattern.BaseAvenger.Avenger;

public class FlyingPower extends Avenger {
    Avenger avenger;
    public FlyingPower(Avenger avenger){
        this.avenger=avenger;
        for(String power : avenger.powers)
            powers.add(power);
        powers.add("Flying Power");
    }
}
