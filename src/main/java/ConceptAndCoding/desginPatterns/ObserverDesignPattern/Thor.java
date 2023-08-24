package ConceptAndCoding.desginPatterns.ObserverDesignPattern;

public class Thor implements Observer{
    @Override
    public void update() {
        System.out.println("Alerting thor !");
    }
}
