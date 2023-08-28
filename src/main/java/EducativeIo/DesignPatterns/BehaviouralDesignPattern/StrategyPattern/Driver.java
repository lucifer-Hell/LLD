package EducativeIo.DesignPatterns.BehaviouralDesignPattern.StrategyPattern;

public class Driver {
    DriveStrategy driveStrategy;
    Driver(DriveStrategy driveStrategy){
        this.driveStrategy=driveStrategy;
    }
    void drive(){
        driveStrategy.drive();
    }
}
