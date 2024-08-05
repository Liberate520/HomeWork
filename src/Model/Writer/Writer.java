package Model.Writer;

import Model.FamilyTree.FamilyTree;

import java.io.IOException;

public interface Writer {
    void saveToFile(String filename, FamilyTree familyTree) throws IOException;
    FamilyTree readFromFile(String filename) throws IOException, ClassNotFoundException;
}
