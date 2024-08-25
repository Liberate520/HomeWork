package Model.Writer;

import Model.FamilyTree.FamilyTree;
import Model.Human.Human;

import java.io.IOException;

public interface Writer {
    void saveToFile(String filename, FamilyTree<Human> familyTree) throws IOException;
    FamilyTree<Human> readFromFile(String filename) throws IOException, ClassNotFoundException;
}
