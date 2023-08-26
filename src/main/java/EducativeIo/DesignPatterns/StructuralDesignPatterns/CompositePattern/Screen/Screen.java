package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Screen;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Product;

public abstract class Screen implements Product {
    String screenSize;
    String screenType;
    public Screen(String screenSize,String screenType){
        this.screenSize=screenSize;
        this.screenType=screenType;
    }
}
