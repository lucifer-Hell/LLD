package ConceptAndCoding.desginPatterns.DecoratorDesignPattern;

import ConceptAndCoding.desginPatterns.DecoratorDesignPattern.BaseAvenger.Avenger;

public class Thor extends Avenger {
    private final String avengerName="Thor";

    public String getAvengerName() {
        return avengerName;
    }
}
