package ru.gb.familytree.writer;

import ru.gb.familytree.family_tree.FamilyTree;
import ru.gb.familytree.human.Human;

import java.util.List;

public interface Writer {
    void saveToFile(List<Human> list, String string);
    void saveToFile(FamilyTree familyTree, String string);
    List<Human> restoreFromFileH (String string);
    FamilyTree restoreFromFileFT (String string);
}
