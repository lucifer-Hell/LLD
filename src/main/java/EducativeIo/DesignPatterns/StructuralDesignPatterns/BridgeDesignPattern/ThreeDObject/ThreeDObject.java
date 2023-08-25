package EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.ThreeDObject;

import EducativeIo.DesignPatterns.StructuralDesignPatterns.BridgeDesignPattern.Color.Color;

public abstract class ThreeDObject {
    String color;
    String type;
    ThreeDObject(Color color){
        this.color=color.getColorType();
    }
    public void getProperties(){
        System.out.println("type: "+type+" color: "+color);
    };
}
