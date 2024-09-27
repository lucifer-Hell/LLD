package EducativeIo.DesignPatterns.BehaviouralDesignPattern.IteratorPattern;

import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Box> boxes=List.of(
          new Box("Jaguar"),
                new Box("trap")
        );
        CustomIterator iterator= new BoxIterator(boxes);
        while (iterator.hasNext()){
            System.out.println(iterator.next().getType());
        }
    }
}
