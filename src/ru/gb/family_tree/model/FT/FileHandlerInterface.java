package ru.gb.family_tree.model.FT;

import ru.gb.family_tree.model.Human.Human;

import java.io.IOException;

public interface FileHandlerInterface {
    void saveFamilyTree(FamilyTreeInterface<Human> familyTree, String filePath) throws IOException;
    FamilyTreeInterface<Human> loadFamilyTree(String filePath) throws IOException, ClassNotFoundException;
}
