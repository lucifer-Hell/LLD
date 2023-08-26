package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Ram;

public class DDR3Ram extends Ram{

    public DDR3Ram() {
        super("DDR3", "15 GIB");
    }

    @Override
    public int getPrice() {
        return 4000;
    }
}
