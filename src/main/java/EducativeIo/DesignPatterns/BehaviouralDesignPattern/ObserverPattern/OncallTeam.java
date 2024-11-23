package EducativeIo.DesignPatterns.BehaviouralDesignPattern.ObserverPattern;

public class OncallTeam implements Observer{
    @Override
    public void update(Object object) {
        if(object instanceof ServerStatus serverStatus){
            if(!serverStatus.status){
                System.out.println("system is down on call team get alert");
            }
        }
    }
}
