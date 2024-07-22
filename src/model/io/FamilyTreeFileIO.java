package model.io;

import java.io.*;

public class FamilyTreeFileIO<T extends Serializable> implements FamilyTreeIO<T> {
    @Override
    public void writeToFile(T object, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        }
    }
}
