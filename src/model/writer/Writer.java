package model.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable, String filePath) throws IOException;
    Serializable read(String filePath) throws IOException, ClassNotFoundException;
}
