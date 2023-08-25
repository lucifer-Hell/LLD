package EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.Color.GreenColor;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.Color.YellowColour;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.ThreeDObject.Box;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.ThreeDObject.Cone;
import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.ThreeDObject.ThreeDObject;

public class Client {
    public static void main(String[] args) {
        ThreeDObject greenBox=new Box(new GreenColor());
        greenBox.getProperties();
        ThreeDObject yellowCone=new Cone(new YellowColour());
        yellowCone.getProperties();
        ThreeDObject yellowBox=new Box(new YellowColour());
        yellowBox.getProperties();
        ThreeDObject greenCone=new Cone(new GreenColor());
        greenCone.getProperties();
    }
}
