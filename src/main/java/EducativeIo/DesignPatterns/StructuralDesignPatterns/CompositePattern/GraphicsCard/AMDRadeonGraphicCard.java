package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.GraphicsCard;

public class AMDRadeonGraphicCard extends GraphicCard{
    public AMDRadeonGraphicCard() {
        super("AMD RADEON GRAPHICS", "10 GIB");
    }

    @Override
    public int getPrice() {
        return 20000;
    }
}
