package Interviews.Walmart;

import java.util.List;

public abstract class Phone {
    String phoneModel;
    List<String> features;
    Phone(String phoneModel, List<String> features){
        this.phoneModel=phoneModel;
        this.features=features;
    }
    abstract String showDetails();
}
