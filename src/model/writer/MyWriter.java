package model.writer;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeItem;

public interface MyWriter<T extends FamilyTreeItem> {
    boolean save(FamilyTree<T> familyTree);

    FamilyTree<T> load();
}
