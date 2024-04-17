package family_tree.model.writer;
import java.io.Serializable;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    FamilyTree<Human> read(String filePath);
}
