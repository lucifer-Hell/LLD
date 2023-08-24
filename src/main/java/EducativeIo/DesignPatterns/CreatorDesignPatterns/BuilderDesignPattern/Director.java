package EducativeIo.DesignPatterns.CreatorDesignPatterns.BuilderDesignPattern;

public class Director {
    public Chair generateChair(ChairBuilder chairBuilder){
        return chairBuilder.buildChair();
    }
}
