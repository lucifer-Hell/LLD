package ConceptAndCoding.defaultVsProtected.CustomHero;

import ConceptAndCoding.defaultVsProtected.Hero.Hero;

public class Rajnikant extends Hero {
    Rajnikant(){
        speak();
        fly();
    }
    // method overriding
    public void fly(){
        System.out.println("FLYING SHIVAJI");
    }


    void test(){
    }

}
