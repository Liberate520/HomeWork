

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void writeToFile(String filename, Serializable member) throws IOException;
    Serializable readFromFile(String filename) throws IOException, ClassNotFoundException;
}
