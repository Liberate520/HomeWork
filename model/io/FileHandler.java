package model.io;

import java.io.IOException;

public interface FileHandler {
    <T> void writeToFile(String filename, T object) throws IOException;
    <T> T readFromFile(String filename) throws IOException, ClassNotFoundException;
}
