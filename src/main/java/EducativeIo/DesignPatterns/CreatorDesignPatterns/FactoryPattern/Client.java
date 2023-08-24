package EducativeIo.DesignPatterns.CreatorDesignPatterns.FactoryPattern;

public class Client {
    public static void main(String[] args) {
        LaptopFactory laptopFactory=new LaptopFactory();
        Laptop laptop= laptopFactory.getLaptop("GamingLaptop");
        System.out.println(laptop.laptopModel);
    }
}
