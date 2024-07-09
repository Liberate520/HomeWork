package family__tree.writer;

import family__tree.family_tree.FamilyTree;

import java.io.IOException;

public interface Writer {
    void writeToFile(FamilyTree familyTree, String fileName) throws IOException;
    FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
