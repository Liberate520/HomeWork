package Util;

import Model.FamilyTree;

import java.io.IOException;

public interface DataHandler<T> {
    void saveFamilyTree(T familyTree, String filename) throws IOException;
    T loadFamilyTree(String filename) throws IOException, ClassNotFoundException;
}
