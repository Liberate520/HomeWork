package ru.gb.family_tree.writer;

import ru.gb.family_tree.model.tree.FamilyTree;

public interface Writer {

    void serializationToFile(FamilyTree tree);
    FamilyTree restoringFromFile();

}
