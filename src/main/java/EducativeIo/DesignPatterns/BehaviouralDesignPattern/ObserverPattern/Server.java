package EducativeIo.DesignPatterns.BehaviouralDesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Server implements Subject{
    private final List<Observer>observers;
    public Server(){
        this.observers=new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(int id) {
        this.observers.remove(id);
    }

    @Override
    public void updateAllObservers(ServerStatus serverStatus) {
        observers.forEach(observer -> observer.update(serverStatus));
    }
}
