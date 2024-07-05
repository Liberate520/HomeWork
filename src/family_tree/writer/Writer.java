package family_tree.writer;

import family_tree.family_tree1.FamilyTree;

import java.io.IOException;

public interface Writer {
    void save(String path, FamilyTree familyTree) throws IOException;
    FamilyTree load(String path) throws IOException, ClassNotFoundException;
}
