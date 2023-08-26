package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Ram;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Product;

public abstract class Ram implements Product {
    String ramType;
    String ramSize;

    Ram(String ramType, String ramSize) {
       this.ramSize=ramSize;
       this.ramType=ramType;
    }
}
