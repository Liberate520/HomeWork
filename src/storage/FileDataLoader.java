package storage;

import model.Person;
import java.io.*;
import java.util.List;

public class FileDataLoader implements DataLoader {
    @Override
    public List<Person> loadData() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("familyTree.dat"))) {
            return (List<Person>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Class not found", e);
        }
    }
}

