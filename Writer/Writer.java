package homeWork.Writer;

import homeWork.Tree.FamilyTree;
import java.io.IOException;

public interface Writer {
    void writeToFile(FamilyTree tree, String fileName) throws IOException;
    FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
