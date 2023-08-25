package EducativeIo.DesignPatterns.CreationalDesignPattern.BuilderDesignPattern;

public class SimpleChair extends Chair{

    SimpleChair(SimpleChairBuilder simpleChairBuilder){
        this.chairDescription=simpleChairBuilder.chairDescription;
        this.chairHeight=simpleChairBuilder.chairHeight;
        this.chairWeight=simpleChairBuilder.chairWeight;
        this.chairType=simpleChairBuilder.chairType;
    }

    public void moveUp(){
        System.out.println("moving up ");
    }
}
