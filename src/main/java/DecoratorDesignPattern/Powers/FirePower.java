package DecoratorDesignPattern.Powers;

import DecoratorDesignPattern.BaseAvenger.Avenger;

public class FirePower extends Avenger {
    Avenger avenger;
    public FirePower(Avenger avenger){
        this.avenger=avenger;
        for(String power : avenger.powers)
            powers.add(power);
        powers.add("Fire Power");
    }
}
