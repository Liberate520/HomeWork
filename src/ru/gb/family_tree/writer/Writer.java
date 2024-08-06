package ru.gb.family_tree.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable) throws IOException;
    Object read() throws IOException, ClassNotFoundException;
    void setPath(String path);
}
