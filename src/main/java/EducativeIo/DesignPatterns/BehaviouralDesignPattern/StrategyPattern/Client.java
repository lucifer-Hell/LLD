package EducativeIo.DesignPatterns.BehaviouralDesignPattern.StrategyPattern;

public class Client {
    public static void main(String[] args) {
        DriveStrategy speedDrivingStrategy=new DriveWithSpeed();
        DriveStrategy slowDrivingStrategy=new DriveSafely();
        Driver raceDriver=new Driver(speedDrivingStrategy);
        raceDriver.drive();
        Driver copDriver= new Driver(slowDrivingStrategy);
        copDriver.drive();
        Driver thiefDriver=new Driver(speedDrivingStrategy);
        thiefDriver.drive();

    }
}
