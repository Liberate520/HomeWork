package family_tree_app.model.work_with_files;

import java.io.Serializable;

import family_tree_app.model.family_tree.FamilyTreeEntry;
import family_tree_app.model.family_tree.Tree;

public interface Savable<T extends FamilyTreeEntry<T>> {

    boolean save(Serializable serializable, String filePath);
    boolean save(Tree<T> tree);
    Object read(String filePath);
    Tree<T> read();
}