package EducativeIo.DesignPatterns.BehaviouralDesignPattern.ObserverPattern;

public class Client {
    public static void main(String[] args) {
        Server server=new Server();
        TechTeam alpha=new TechTeam();
        TechTeam beta=new TechTeam();
        OncallTeam alphaOncall=new OncallTeam();
        OncallTeam betaOnCall=new OncallTeam();
        server.addObserver(alpha);
        server.addObserver(beta);
        server.addObserver(alphaOncall);
        server.addObserver(betaOnCall);
        server.updateAllObservers(new ServerStatus(false));
        server.updateAllObservers(new ServerStatus(true));
    }
}
