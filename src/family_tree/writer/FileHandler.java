package family_tree.writer;

import java.io.*;
import java.util.List;

import family_tree.human.Human;

public class FileHandler implements Writable {

    @Override
    public void saveToFile(String fileName, List<Human> humans) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(humans);
            System.out.println("Data saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Human> loadFromFile(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Human> humans = (List<Human>) objectInputStream.readObject();
            System.out.println("Data loaded from file: " + fileName);
            return humans;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
            return null;
        }
    }
}
