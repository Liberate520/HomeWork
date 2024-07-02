package Writers;

import java.io.IOException;

import FamilyTree.FamilyTree;

public interface Writer {
    FamilyTree read(String path) throws IOException, ClassNotFoundException;
    void write(String path, FamilyTree familyTree) throws IOException;
}
