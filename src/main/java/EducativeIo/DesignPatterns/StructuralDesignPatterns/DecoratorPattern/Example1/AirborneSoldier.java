package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern.Example1;

public class AirborneSoldier extends SpecializedSoldier{

    public AirborneSoldier(Soldier soldier) {
        super(soldier);
        skills.add("airborne skills");
    }
    public void fly(){
        System.out.println("soldier flying in sky !!");
    }
}
