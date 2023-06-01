package DecoratorDesignPattern.Powers;

import DecoratorDesignPattern.BaseAvenger.Avenger;

public class FlyingPower extends Avenger {
    Avenger avenger;
    public FlyingPower(Avenger avenger){
        this.avenger=avenger;
        for(String power : avenger.powers)
            powers.add(power);
        powers.add("Flying Power");
    }
}
