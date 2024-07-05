package io;

import model.FamilyTree;

public interface FileHandler {
    void saveFamilyTree(FamilyTree tree, String filename);
    FamilyTree loadFamilyTree(String filename);
    void writeToFile(String filename, Object obj);
    Object readFromFile(String filename);
}
