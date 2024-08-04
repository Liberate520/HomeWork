package com.example.familytree.util;

import com.example.familytree.model.FamilyTree;
import java.io.IOException;

public interface FileOperations {
    void saveToFile(String filename) throws IOException;
    FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
