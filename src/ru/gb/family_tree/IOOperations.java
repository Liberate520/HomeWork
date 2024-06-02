package ru.gb.family_tree;

import java.io.IOException;
import java.util.List;

public interface IOOperations<T> {
    void saveTree(List<T> nodeList, String filename) throws IOException;
    List<T> loadTree(String filename) throws IOException, ClassNotFoundException;
}
