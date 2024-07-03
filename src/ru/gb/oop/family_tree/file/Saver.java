package ru.gb.oop.family_tree.file;

import ru.gb.oop.family_tree.FamilyTree;

import java.io.Serializable;

public interface Saver {
    boolean save(Serializable obj);
    FamilyTree load();
}
