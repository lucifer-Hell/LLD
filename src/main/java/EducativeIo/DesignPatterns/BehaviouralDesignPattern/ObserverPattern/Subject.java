package EducativeIo.DesignPatterns.BehaviouralDesignPattern.ObserverPattern;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(int id);
    void updateAllObservers(ServerStatus serverStatus);
}
