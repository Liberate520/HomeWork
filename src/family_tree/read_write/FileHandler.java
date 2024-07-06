package family_tree.read_write;

import family_tree.creators.human.Human;

import java.io.*;
import java.util.Map;

public class FileHandler<K, V extends Serializable> implements Writer<K, V> {

    @Override
    public void writeMap(Map<K, V> map, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<K, V> readMap(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Map<K, V>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
