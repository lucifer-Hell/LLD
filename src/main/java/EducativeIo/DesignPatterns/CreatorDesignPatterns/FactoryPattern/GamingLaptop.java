package EducativeIo.DesignPatterns.CreatorDesignPatterns.FactoryPattern;

public class GamingLaptop extends Laptop {
    boolean hasVsync;
    boolean hasGameMode;
    GamingLaptop(){
        hasVsync=true;
        hasGameMode=true;
        laptopModel="ASUZ ZEN PRO";
    }
}
