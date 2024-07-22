package model.io;

import java.io.IOException;

public interface FamilyTreeIO<T> {
    void writeToFile(T object, String fileName) throws IOException;
    T readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
