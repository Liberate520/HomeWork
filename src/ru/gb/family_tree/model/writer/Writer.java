package ru.gb.family_tree.model.writer;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writer {
    void saveObject(Object obj, String objName) throws IOException;
    Object readObject(String objName) throws FileNotFoundException, IOException, ClassNotFoundException;
}
