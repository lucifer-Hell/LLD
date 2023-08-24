package ConceptAndCoding.desginPatterns.ObserverDesignPattern;

public class Test {
    public static void main(String[] args) {
        Thanos thanos=new Thanos();
        IronMan ironMan=new IronMan();
        Thor thor=new Thor();
        thanos.addObserver(ironMan);
        thanos.addObserver(thor);
        thanos.awakeThanos();
    }
}
