package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern.Example2;

public class Client {
    public static void main(String[] args) {
        IceCream iceCream=new IceCream();
        IceCreamDecocrator whippedIceCream=new WhipCreamDecorator(iceCream);
        IceCreamDecocrator chocChipWhipedCream=new ChocoCake(whippedIceCream);
        System.out.println(chocChipWhipedCream.getDetail());
    }
}
