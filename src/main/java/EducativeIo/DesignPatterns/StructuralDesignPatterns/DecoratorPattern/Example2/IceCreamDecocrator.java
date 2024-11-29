package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern.Example2;

public  abstract class IceCreamDecocrator extends IceCream {
    IceCream iceCream;
    IceCreamDecocrator(IceCream iceCream){
        this.iceCream=iceCream;
    }
    @Override
    public abstract String getDetail();
}
