package EducativeIo.DesignPatterns.CreationalDesignPattern.FactoryPattern;

public class LaptopFactory {
    /* factory pattern --> */
    public Laptop getLaptop(String laptopType){
        return switch (laptopType) {
            case "GamingLaptop" -> new GamingLaptop();
            case "WorkLaptop" -> new WorkLaptop();
            default -> null;
        };
    }
    // Abstract factory can be simply given as factory of factory
    // LaptopFactory.getGamingLaptopFactory().getAsusLaptop();
}
