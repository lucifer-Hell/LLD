package EducativeIo.DesignPatterns.BehaviouralDesignPattern.IteratorPattern;

import java.util.List;

public class GIterator <T>{
    List<T> items;
    int size,idx;
    GIterator(List<T> items){
        this.items=items;
        size= items.size();
        if(!items.isEmpty()) idx=0;
        else idx=-1;
    }
    public boolean hasNext(){
       return idx<size;
    }
    public T next(){
        if(idx==-1 || idx==size) return null;
        else return items.get(idx++);
    }
}
