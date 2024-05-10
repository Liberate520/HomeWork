package family_tree.writable;

import family_tree.person.Person;

import java.io.*;
import java.util.Map;

public class FileHandler implements FileHandlerInterface {

    @Override
    public void writeToFile(Map<Integer, Person> peopleMap, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(peopleMap);
            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при записи данных в файл " + filename + ": " + e.getMessage());
        }
    }

    @Override
    public Map<Integer, Person> readFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Map<Integer, Person> peopleMap = (Map<Integer, Person>) inputStream.readObject();
            System.out.println("Данные успешно прочитаны из файла " + filename);
            return peopleMap;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении данных из файла " + filename + ": " + e.getMessage());
            return null;
        }
    }
}
