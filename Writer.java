package Writer;

import familyTree.FamilyTree;

public interface Writer {
    void writeToFile(String fileName, FamilyTree familyTree);
    FamilyTree readFromFile(String fileName);
}