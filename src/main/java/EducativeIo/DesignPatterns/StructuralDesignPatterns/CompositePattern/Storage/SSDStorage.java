package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Storage;

public class SSDStorage extends Storage {
    public SSDStorage() {
        super("SSD", "500 GB");
    }

    @Override
    public int getPrice() {
        return 9000;
    }
}
