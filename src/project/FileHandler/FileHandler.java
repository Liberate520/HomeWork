package project.FileHandler;

import java.io.IOException;
import java.io.Serializable;

public interface FileHandler {
    void writeToFile(String filename, Serializable member) throws IOException;
    Serializable readFromFile(String filename) throws IOException, ClassNotFoundException;
}