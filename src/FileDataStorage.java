import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataStorage implements DataStorage {

    @Override
    public void saveToFile(String filename, List<Person> people) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
        }
    }

    @Override
    public List<Person> loadFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Person>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

