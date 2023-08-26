package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Screen;

public class SixteenInchScreen extends Screen {
    public SixteenInchScreen() {
        super("16 inch", "led");
    }

    @Override
    public int getPrice() {
        return 9000;
    }
}
