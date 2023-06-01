package DecoratorDesignPattern.Powers;

import DecoratorDesignPattern.BaseAvenger.Avenger;

public class InvisiblePower extends Avenger {
    Avenger avenger;
    public InvisiblePower(Avenger avenger){
        this.avenger=avenger;
        for(String power : avenger.powers)
            powers.add(power);
        powers.add("Invisible power");
    }
}
