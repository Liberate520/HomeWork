package com.example.familytree;

import java.io.IOException;
import java.util.Map;

public interface FileOperations {
    void saveToFile(String filename, FamilyTree familyTree) throws IOException;
    FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
