package ru.gb.family_tree;

import java.io.IOException;
import java.util.List;

public interface IOOperations {
    void saveTree(List<Node> nodes, String filename) throws IOException;
    List<Node> loadTree(String filename) throws IOException, ClassNotFoundException;
}