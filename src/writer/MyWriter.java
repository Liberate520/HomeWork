package writer;

import family_tree.FamilyTree;
import family_tree.FamilyTreeItem;

public interface MyWriter<T extends FamilyTreeItem> {
    boolean save(FamilyTree<T> familyTree);

    FamilyTree<T> load();
}
