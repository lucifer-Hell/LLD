package ConceptAndCoding.desginPatterns.ObserverDesignPattern;

public class IronMan implements Observer{
    @Override
    public void update() {
        System.out.println("Iron man alerted ");
    }
}
