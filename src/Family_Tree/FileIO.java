package Family_Tree;

import java.io.*;
import java.util.List;

public class FileIO<T> implements FileIOInterface<T> {
    @Override
    public void writeToFile(String fileName, T data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
