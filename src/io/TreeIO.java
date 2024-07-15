package io;

import model.FamilyTree;

import java.io.IOException;

public interface TreeIO {
    void saveToFile(FamilyTree tree, String filename) throws IOException;
    FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
