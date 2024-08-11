package Model;

import java.io.IOException;

public interface Writeable {
    void writeToFile(FamilyTree familyTree, String fileName) throws IOException;

    FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
