package EducativeIo.DesignPatterns.CreatorDesignPatterns.BuilderDesignPattern;

public class Client {
    public static void main(String[] args) {
        Director director=new Director();
        Chair myCustomGamingChair= director.generateChair(new GamingChairBuilder());
        Chair myCustomSimpleChair= director.generateChair(new SimpleChairBuilder());
        System.out.println("custom chair type: "+myCustomGamingChair.chairDescription);
        System.out.println("custom chair type: "+myCustomSimpleChair.chairDescription);
    }
}
