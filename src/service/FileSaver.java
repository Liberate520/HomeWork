package service;

import model.FamilyTree;

import java.io.IOException;

public interface FileSaver {
    void save(String fileName, FamilyTree<?> tree) throws IOException;
}
