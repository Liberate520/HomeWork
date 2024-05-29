package family_tree_app.work_with_files;

import java.io.Serializable;

import family_tree_app.family_tree.FamilyTreeEntry;
import family_tree_app.family_tree.Tree;

public interface Savable {

    boolean save(Serializable serializable, String filePath);
    boolean save(Tree<FamilyTreeEntry> tree);
    Object read(String filePath);
    Tree<FamilyTreeEntry> read();
}

