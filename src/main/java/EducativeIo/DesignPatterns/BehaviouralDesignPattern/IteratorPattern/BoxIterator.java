package EducativeIo.DesignPatterns.BehaviouralDesignPattern.IteratorPattern;

import java.util.List;

public class BoxIterator implements CustomIterator{
    List<Box> boxes;
    int position=0;

    BoxIterator(List<Box> boxes){
        this.boxes=boxes;
    }

    @Override
    public boolean hasNext() {
        return position < boxes.size();
    }

    @Override
    public Box next() {
        return boxes.get(position++);
    }
}
