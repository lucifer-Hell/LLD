package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern.Example1;

public class NavySoldier extends SpecializedSoldier{
    public NavySoldier(Soldier soldier) {
        super(soldier);
        skills.add("swimming skill");
    }
}
