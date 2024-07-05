package family__tree;

import java.io.IOException;

public interface Writer {
    void writeToFile(FamilyTree familyTree, String fileName) throws IOException;
    FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
