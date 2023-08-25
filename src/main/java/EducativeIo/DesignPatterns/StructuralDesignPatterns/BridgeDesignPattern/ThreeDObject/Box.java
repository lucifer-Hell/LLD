package EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.ThreeDObject;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.Color.Color;

public class Box extends ThreeDObject{

    public Box(Color color) {
        super(color);
        type="BOX";
    }

}
