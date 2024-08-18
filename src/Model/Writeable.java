package Model;

import java.io.IOException;

public interface Writeable<T extends Human> {
    void writeToFile(FamilyTree<T> familyTree, String fileName) throws IOException;

    FamilyTree<T> readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
