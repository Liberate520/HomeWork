package family_tree.writer;
import java.io.Serializable;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Human;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    FamilyTree<Human> read(String filePath);
}
