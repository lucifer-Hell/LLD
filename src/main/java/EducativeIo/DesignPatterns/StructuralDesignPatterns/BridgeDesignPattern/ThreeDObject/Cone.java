package EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.ThreeDObject;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.Color.Color;

public class Cone extends ThreeDObject{
    public Cone(Color color) {
        super(color);
        type="Cone";
    }

}
