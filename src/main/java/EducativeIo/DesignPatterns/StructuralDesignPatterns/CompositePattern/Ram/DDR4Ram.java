package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Ram;

public class DDR4Ram extends Ram {
    public DDR4Ram() {
        super("DDR4", "8 GIB");
    }

    @Override
    public int getPrice() {
        return 6000;
    }
}
