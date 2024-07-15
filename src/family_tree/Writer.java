package ru.gb.family_tree;

import java.io.IOException;

public interface Writer {
    void save(String fileName, FamilyTree familyTree) throws IOException;
    FamilyTree load(String fileName) throws IOException, ClassNotFoundException;
}
