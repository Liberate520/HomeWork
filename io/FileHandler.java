package io;

import model.FamilyTree;

public interface FileHandler {
    <T> void writeToFile(String fileName, FamilyTree<T> tree);
    <T> FamilyTree<T> readFromFile(String fileName);
}
