package EducativeIo.DesignPatterns.CreationalDesignPattern.BuilderDesignPattern;

public class GamingChairBuilder extends ChairBuilder{


    @Override
    public Chair buildChair() {
        this.setChairType("GamingChair")
                .setChairDescription("Ultimate game chair for professional gamers");
        return new GamingChair(this);
    }
}
