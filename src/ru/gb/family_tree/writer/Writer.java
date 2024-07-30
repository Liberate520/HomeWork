package ru.gb.family_tree.writer;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.service.FamilyTreeItem;

import java.util.List;

public interface Writer<T extends FamilyTreeItem<T>> {
    void saveToFile(List<T> list, String string);
    void saveToFile(FamilyTree<T> familyTree, String string);
    List<T> restoreFromFileH (String string);
    FamilyTree<T> restoreFromFileFT (String string);
}
