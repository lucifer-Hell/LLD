package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.GraphicsCard;

public class NvidiaGraphiCard extends GraphicCard {
    public NvidiaGraphiCard() {
        super("NIVIDA", "6GIB");
    }

    @Override
    public int getPrice() {
        return 6500;
    }
}
