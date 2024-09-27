package Interviews.Walmart;

import java.util.List;

public class Iphone extends Phone{
    Iphone(String phoneModel, List<String> features){
        super(phoneModel,features);
    }
    @Override
    String showDetails() {
        return "features of iphone "+features;
    }
}
