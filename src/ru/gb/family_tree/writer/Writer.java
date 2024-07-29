package ru.gb.family_tree.writer;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;

import java.util.List;

public interface Writer {
    void saveToFile(List<Human> list, String string);
    void saveToFile(FamilyTree familyTree, String string);
    List<Human> restoreFromFileH (String string);
    FamilyTree restoreFromFileFT (String string);
}
