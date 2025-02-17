package model;
import Presenter.*;
import java.io.*;
import java.util.List;

public class FileIO<T extends Node> extends IOOperations<T> {

    @Override
    public void saveTree(List<T> nodeList, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(nodeList);
        }
    }

    @Override
    public List<T> loadTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        }
    }
}
