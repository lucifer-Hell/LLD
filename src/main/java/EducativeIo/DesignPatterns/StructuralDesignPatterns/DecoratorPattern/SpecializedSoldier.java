package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecializedSoldier extends Soldier{
    Soldier soldier;
    SpecializedSoldier(Soldier soldier){
        this.soldier=soldier;
        this.skills=soldier.skills;
    }
    List<String> getSkills(){
        return skills;
    }
}
