package com.example.FamilyTree;

import java.io.Serializable;

public interface FileProcessing {
    void save(String path, Serializable object);
    FamilyTree read(String path);
}
