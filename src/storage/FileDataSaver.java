package storage;

import model.Person;

import java.io.*;
import java.util.List;

public class FileDataSaver implements DataSaver {
    @Override
    public void saveData(List<Person> data) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("familyTree.dat"))) {
            oos.writeObject(data);
        }
    }
}
