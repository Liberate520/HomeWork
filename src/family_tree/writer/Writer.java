package family_tree.writer;

import family_tree.family_tree1.FamilyTree;
import family_tree.human.Human;

import java.io.IOException;

public interface Writer {
    void save(FamilyTree<?> familyTree) throws IOException;
    FamilyTree<Human> load() throws IOException, ClassNotFoundException;
}
