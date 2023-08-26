package EducativeIo.DesignPatterns.StructuralDesignPatterns.CompositePattern.Storage;

public class HDDStorage extends Storage{
    public HDDStorage() {
        super("HDD","1 TB" );
    }

    @Override
    public int getPrice() {
        return 5000;
    }
}
