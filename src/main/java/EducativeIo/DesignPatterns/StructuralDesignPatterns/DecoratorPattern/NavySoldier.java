package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern;

import java.util.ArrayList;

public class NavySoldier extends SpecializedSoldier{
    public NavySoldier(Soldier soldier) {
        super(soldier);
        skills.add("swimming skill");
    }
}
