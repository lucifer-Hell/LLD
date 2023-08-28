package EducativeIo.DesignPatterns.BehaviouralDesignPattern.ObserverPattern;

public class TechTeam implements Observer{
    @Override
    public void update(Object object) {
        if(object instanceof ServerStatus){
            ServerStatus serverStatus=(ServerStatus) object;
            if(!serverStatus.status){
                System.out.println(" tech team get on call system is down ");
            }
        }
    }
}
