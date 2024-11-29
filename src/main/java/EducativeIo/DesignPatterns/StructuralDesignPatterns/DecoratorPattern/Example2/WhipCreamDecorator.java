package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern.Example2;

public class WhipCreamDecorator extends IceCreamDecocrator{
    private final IceCream iceCream;
    WhipCreamDecorator(IceCream iceCream){
        super(iceCream);
        this.iceCream=iceCream;
    }
    @Override
    public String getDetail() {
        return iceCream.getDetail()+", whipped cream ";
    }
}
