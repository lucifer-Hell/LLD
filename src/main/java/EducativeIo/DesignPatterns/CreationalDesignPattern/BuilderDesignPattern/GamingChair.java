package EducativeIo.DesignPatterns.CreationalDesignPattern.BuilderDesignPattern;

public class GamingChair extends Chair {
    GamingChair(GamingChairBuilder gamingChairBuilder){
        this.chairDescription=gamingChairBuilder.chairDescription;
        this.chairHeight= gamingChairBuilder.chairHeight;
        this.chairType= gamingChairBuilder.chairType;
        this.chairPrice= gamingChairBuilder.chairPrice;
        this.chairWeight=gamingChairBuilder.chairWeight;
    }
    public void tiltLeft(){
        System.out.println("tilting left");
    };
    public void tiltRight(){
        System.out.println("tilting right");
    };
}
