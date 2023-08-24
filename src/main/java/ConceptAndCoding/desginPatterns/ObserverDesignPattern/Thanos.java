package ConceptAndCoding.desginPatterns.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Thanos implements Observable {
    private boolean isSleeping;
    private List<Observer> observerList;
    Thanos(){
        isSleeping=false;
        observerList=new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }
    void setState(boolean isSleeping){
        this.isSleeping=isSleeping;
        if(!this.isSleeping)
            update();
    }

    @Override
    public void update() {
        for(Observer observer: observerList)
            observer.update();
    }

    public void awakeThanos(){
        System.out.println("Waking up thanos !!");
        this.setState(false);
    }


}
