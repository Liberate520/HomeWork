package model.io;

import java.io.IOException;

public interface IFileHandler {
    void save(String filename, Object obj) throws IOException;
    Object load(String filename) throws IOException, ClassNotFoundException;
}
