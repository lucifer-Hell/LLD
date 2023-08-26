package EducativeIo.DesignPatterns.StructuralDesignPatterns.DecoratorPattern;

public class Client {
    public static void main(String[] args) {
        // using decorator pattern we can customize a special soldier as much as we want
        // without worrying about more hard code bindings
        SpecializedSoldier rajputanaSoldier = new NarcoSoldier(new NavySoldier(new Soldier()));
        System.out.println(rajputanaSoldier.skills);
        SpecializedSoldier sikhRegimentSoldier = new AirborneSoldier(new NavySoldier(new NarcoSoldier(new Soldier())));
        System.out.println(sikhRegimentSoldier.skills);
    }
}
