package family_tree.model.writer;

import family_tree.model.family_tree1.FamilyTree;
import family_tree.model.human.Human;
import java.io.IOException;

public interface Writer {
    void save(String FILE_PATH, FamilyTree<?> familyTree) throws IOException;
    FamilyTree<Human> load(String FILE_PATH) throws IOException, ClassNotFoundException;
}
