package Family_Tree;

import java.io.Serializable;

public interface FileIOInterface {
    void writeToFile(String fileName, Serializable object);
    FamilyTree readFromFile(String fileName);
}
