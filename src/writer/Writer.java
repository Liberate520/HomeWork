package writer;

import familytree.FamilyTree;

public interface Writer {
    void writeToFile(FamilyTree tree, String fileName);
    FamilyTree readFromFile(String fileName);
}
