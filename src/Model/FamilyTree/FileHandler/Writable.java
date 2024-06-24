package Model.FamilyTree.FileHandler;

import java.io.IOException;

public interface Writable {
    void writeObjectToFile(Object obj, String filePath) throws IOException;
    Object recoverObjectFromFile(String filePath) throws IOException, ClassNotFoundException;
}
