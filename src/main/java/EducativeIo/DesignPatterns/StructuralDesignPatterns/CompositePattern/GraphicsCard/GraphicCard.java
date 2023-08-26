package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.GraphicsCard;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Product;

public abstract class GraphicCard implements Product {
    String companyType;
    String computingCapacity;
    GraphicCard(String companyType,String computingCapacity){
        this.companyType=companyType;
        this.computingCapacity=computingCapacity;
    }
}
