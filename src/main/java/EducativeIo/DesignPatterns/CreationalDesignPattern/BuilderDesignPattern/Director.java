package EducativeIo.DesignPatterns.CreationalDesignPattern.BuilderDesignPattern;

public class Director {
    public Chair generateChair(ChairBuilder chairBuilder){
        return chairBuilder.buildChair();
    }
}
