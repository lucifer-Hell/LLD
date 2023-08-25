package EducativeIo.DesignPatterns.CreationalDesignPattern.BuilderDesignPattern;

public class SimpleChairBuilder extends ChairBuilder{

    @Override
    public Chair buildChair() {
        this.setChairDescription("simple chair with no extra features")
                .setChairType("simpleGamingChair");
        return new SimpleChair(this);
    }
}
