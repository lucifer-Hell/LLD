package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Storage;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Product;

public abstract class Storage implements Product {
    String storageType;
    String storageSize;
    public Storage(String storageType, String storageSize){
        this.storageType=storageType;
        this.storageSize=storageSize;
    }
}
