package ru.gb.family_tree;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileIO implements IOOperations {

    @Override
    public void saveTree(List<Node> nodeList, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(nodeList);
        }
    }

    @Override
    public List<Node> loadTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Node>) ois.readObject();
        }
    }
}