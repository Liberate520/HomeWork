package family_tree.writer;

import family_tree.FamilyTree;

import java.io.IOException;

public interface Writer {
    void save(String path, FamilyTree familyTree) throws IOException;
    FamilyTree load(String path) throws IOException, ClassNotFoundException;
}
