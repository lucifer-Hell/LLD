package ConceptAndCoding.desginPatterns.DecoratorDesignPattern.BaseAvenger;

import java.util.*;

public class Avenger {
    public List<String> powers=new ArrayList<>();
    public void listAllPowers(){
        System.out.println("Listing all powers of avenger : \n");
        for(String power: powers)
            System.out.print(power + "-");
        System.out.println();
    }
}
