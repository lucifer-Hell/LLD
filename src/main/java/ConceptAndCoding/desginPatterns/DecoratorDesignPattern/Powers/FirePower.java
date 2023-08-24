package ConceptAndCoding.desginPatterns.DecoratorDesignPattern.Powers;

import ConceptAndCoding.desginPatterns.DecoratorDesignPattern.BaseAvenger.Avenger;

public class FirePower extends Avenger {
    Avenger avenger;
    public FirePower(Avenger avenger){
        this.avenger=avenger;
        powers.addAll(avenger.powers);
        powers.add("Fire Power");
    }
}
