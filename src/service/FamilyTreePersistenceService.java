package service;

import java.io.IOException;

public interface FamilyTreePersistenceService {
    void saveFamilyTree(String fileName) throws IOException;
    void loadFamilyTree(String fileName) throws IOException, ClassNotFoundException;
}
