package ru.gb.family_tree;

import java.io.IOException;
import java.util.List;

public interface IOOperations {
    void saveTree(List<Node> nodeList, String filename) throws IOException;
    List<Node> loadTree(String filename) throws IOException, ClassNotFoundException;
}