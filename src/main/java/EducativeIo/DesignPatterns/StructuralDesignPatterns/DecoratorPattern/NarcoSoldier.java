package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern;

public class NarcoSoldier extends SpecializedSoldier{
    public NarcoSoldier(Soldier soldier) {
        super(soldier);
        skills.add("narcos killing skill");
    }
    void killInGround(){
        System.out.println("Soldier killing in ground ");
    }
}
