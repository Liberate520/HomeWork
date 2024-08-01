package familytree.util;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    void writeToFile(Serializable serializable);
    Object readFromFile();
    void setPath(String path);
}