package ru.gb.family_tree.writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writer {

    void write(Serializable serializable) throws IOException;

    Object read() throws IOException, ClassNotFoundException;

   String getPath();

    void setPath(String path);
}
