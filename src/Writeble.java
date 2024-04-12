import java.io.*;

interface Serializable {
    void serialize(String filename, Object obj) throws IOException;
    Object deserialize(String filename) throws IOException, ClassNotFoundException;
}

class FileHandler implements Serializable {
    public void serialize(String filename, Object obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
        }
    }

    public Object deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        }
    }
}