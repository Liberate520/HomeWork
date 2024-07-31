package model.Writer;

import model.familyTree.FamilyTree;
import model.familyTree.Human;

public interface Writer {
    void writeToFile(String fileName, FamilyTree<Human> familyTree);
    FamilyTree<Human> readFromFile(String fileName);
}