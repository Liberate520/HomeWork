package ru.gb.oop.family_tree.save_load;

import ru.gb.oop.family_tree.tree.FamilyTree;

import java.io.Serializable;

public interface Saver {
    boolean save(Serializable obj);
    FamilyTree load();
}
