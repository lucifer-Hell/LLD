package EducativeIo.DesignPatterns.CreatorDesignPatterns.BuilderDesignPattern;

public abstract class ChairBuilder {
    String chairType;
    String chairDescription;
    String chairPrice;
    String chairWeight;
    String chairHeight;

    public ChairBuilder setChairType(String chairType){
        this.chairType=chairType;
        return this;
    }


    public ChairBuilder setChairDescription(String chairDescription){
        this.chairDescription=chairDescription;
        return this;
    }

    public abstract Chair buildChair();
}
