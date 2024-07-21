package Family_tree;

import java.util.List;

public interface Writer {
    void writeToFile(String fileName, FamilyTree familyTree);
    FamilyTree readFromFile(String fileName);
}