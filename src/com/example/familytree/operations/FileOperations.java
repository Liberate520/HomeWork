package com.example.familytree.operations;

import com.example.familytree.FamilyTree;
import com.example.familytree.model.Person;

import java.io.*;

public interface FileOperations {
    void saveToFile(String filename, FamilyTree<Person> tree);
    FamilyTree<Person> loadFromFile(String filename);
}

