package ru.gb.familytree.writer;

import ru.gb.familytree.family_tree.FamilyTree;
import ru.gb.familytree.human.Human;

import java.util.List;

public interface Writer {
    public void saveToFile(List<Human> list, String string);
    public void saveToFile(FamilyTree familyTree, String string);
    public List<Human> restoreFromFileH (String string);
    public FamilyTree restoreFromFileFT (String string);
}
