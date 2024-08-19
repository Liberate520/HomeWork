package homeWork.Model.Writer;

import java.io.IOException;

import homeWork.Model.Tree.FamilyTree;

public interface Writer {
    void writeToFile(FamilyTree tree, String fileName) throws IOException;
    FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
