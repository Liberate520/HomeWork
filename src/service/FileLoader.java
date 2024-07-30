package service;

import model.FamilyTree;

import java.io.IOException;

public interface FileLoader {
    FamilyTree<?> load(String fileName) throws IOException, ClassNotFoundException;
}
