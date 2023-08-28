package EducativeIo.DesignPatterns.BehaviouralDesignPattern.StrategyPattern;

public class DriveSafely implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving safely with slow speed");
    }
}
