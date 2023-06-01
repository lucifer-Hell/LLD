package DecoratorDesignPattern;

import DecoratorDesignPattern.BaseAvenger.Avenger;
import DecoratorDesignPattern.Powers.FirePower;
import DecoratorDesignPattern.Powers.FlyingPower;
import DecoratorDesignPattern.Powers.InvisiblePower;

public class Test {
    public static void main(String[] args) {
        Thor thor=new Thor();
        Avenger thorWithFlyingPower= new FlyingPower(thor);
        Avenger thorWithFirePower = new FirePower(thor);
        Avenger thorWithFlyingAndFirePower=new FirePower(new FlyingPower(thor));
        thorWithFirePower.listAllPowers();
//        System.out.println(thorWithFirePower.powers);
        thorWithFlyingPower.listAllPowers();
        thorWithFlyingAndFirePower.listAllPowers();
        Avenger x=new FlyingPower(new FirePower(new InvisiblePower(thor)));
        System.out.println(x.powers);
    }
}
