package model;
import java.io.*;
import java.util.List;

public class FileTreeIO implements TreeIO<Node> {
    @Override
    public void saveTree(List<Node> nodeList, String filename) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(nodeList);
        }
    }

    @Override
    public List<Node> loadTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Node>) inputStream.readObject();
        }
    }
}
