package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.GraphicsCard.GraphicCard;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Ram.Ram;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Screen.Screen;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Storage.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Laptop implements Product {
    // A LAPTOP HAVE VARIOUS PARTS
    List<Product> components;
    public Laptop(Product ...components){
        this.components=new ArrayList<>();
        this.components.addAll(Arrays.asList(components));
    }
    public int getPrice(){
        // base price + components price
        int totalComponentPrice=0;
        for(Product component : components)
            totalComponentPrice+=component.getPrice();
        return 10000+totalComponentPrice;
    }
}
