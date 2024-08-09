package familytree.service;

import familytree.model.FamilyTree;

import java.io.*;

public interface Writer {
    void save(FamilyTree familyTree, String fileName) throws IOException;
    FamilyTree load(String fileName) throws IOException, ClassNotFoundException;
}