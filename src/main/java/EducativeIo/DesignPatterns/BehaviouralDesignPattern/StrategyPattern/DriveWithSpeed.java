package EducativeIo.DesignPatterns.BehaviouralDesignPattern.StrategyPattern;

public class DriveWithSpeed implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("driving with speed");
    }
}
