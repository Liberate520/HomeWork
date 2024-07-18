package familytree.io;


import familytree.model.FamilyTree;

import java.io.IOException;

public interface FamilyTreeIO {
    void writeToFile(FamilyTree familyTree, String fileName) throws IOException;
    FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException;
}

