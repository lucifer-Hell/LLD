package ConceptAndCoding.desginPatterns.StrategyDesignPattern;

public class StrategyTest {
    public static void main(String[] args) {
        DrStrange drStrange=new DrStrange();
        Thor thor=new Thor();
        IronMan ironMan=new IronMan();
        drStrange.fly();
        thor.fly();
        ironMan.fly();
    }
}
