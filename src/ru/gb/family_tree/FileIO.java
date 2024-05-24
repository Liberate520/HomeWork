package ru.gb.family_tree;

import java.io.*;
import java.util.List;

public class FileIO implements IOOperations {
    @Override
    public void saveTree(List<Node> nodes, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(nodes);
        }
    }

    @Override
    public List<Node> loadTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Node>) obj;
            } else {
                throw new ClassNotFoundException("Файл не содержит список узлов");
            }
        }
    }
}