package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Screen;

public class ThriteenInchScreen extends Screen {
    public ThriteenInchScreen() {
        super("13 inch", "oled");
    }

    @Override
    public int getPrice() {
        return 7000;
    }
}
