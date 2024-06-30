import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Класс для операций с файлами, реализующий интерфейс FileOperations
class FileFamilyTreeOperations implements FileOperations {

    @Override
    public void saveToFile(String filename, List<Person> members) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(members);
            System.out.println("Файл сохранен: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> loadFromFile(String filename) {
        List<Person> members = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            members = (List<Person>) ois.readObject();
            System.out.println("Файл загружен: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return members;
    }
}