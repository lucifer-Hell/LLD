package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern.Example2;

public class ChocoCake extends IceCreamDecocrator{
    ChocoCake(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDetail() {
        return iceCream.getDetail()+" , choco cake ";
    }
}
