package family_tree.read_write;

import family_tree.family_tree.FamilyTree;

import java.io.IOException;

public interface Writer {
    FamilyTree read(String path) throws IOException, ClassNotFoundException;
    void write(String path, FamilyTree tree) throws IOException;
}
