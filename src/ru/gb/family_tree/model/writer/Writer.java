package ru.gb.family_tree.model.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    boolean writeToFile(Serializable object) throws IOException;
    Object readFromFile() throws IOException, ClassNotFoundException;
    void setPath(String path);
}

