package family_TREE.model.save;

import family_TREE.model.family_tree.FamilyTree;
import family_TREE.model.human.Human;

import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
