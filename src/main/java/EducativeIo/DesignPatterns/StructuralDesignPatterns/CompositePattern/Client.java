package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.GraphicsCard.AMDRadeonGraphicCard;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.GraphicsCard.NvidiaGraphiCard;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Ram.DDR3Ram;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Ram.DDR4Ram;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Screen.SixteenInchScreen;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Screen.ThriteenInchScreen;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Storage.HDDStorage;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Storage.SSDStorage;

public class Client {
    public static void main(String[] args) {
        Laptop asusTufGamingLaptop= new Laptop(
                new DDR4Ram(),
                new SixteenInchScreen(),
                new SSDStorage(),
                new NvidiaGraphiCard()
        );
        System.out.println("price of asus tuf gaming : "+asusTufGamingLaptop.getPrice());
        Laptop dellWorkLaptop= new Laptop(
                new DDR3Ram(),new ThriteenInchScreen(),new HDDStorage()
        );
        System.out.println("price of dellwork laptops : "+dellWorkLaptop.getPrice());
        Laptop dellGamingLaptop= new Laptop(
                new DDR4Ram(),
                new ThriteenInchScreen(),
                new SSDStorage(),
                new AMDRadeonGraphicCard()
        );
        System.out.println("price of dell gaming laptops : "+dellGamingLaptop.getPrice());
    }
}
