package ru.gb.family_tree.writer;

import java.io.IOException;

public interface Writer {
    void saveToFile(String fileName) throws IOException;
    void loadFromFile(String fileName) throws IOException, ClassNotFoundException;

}
