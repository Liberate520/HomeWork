package homeWork.Writer;

import java.io.*;

public class FileHandler implements Writer {

    @Override
    public <T> void writeToFile(T object, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        } catch (IOException e) {
            throw new IOException("Ошибка записи в файл: " + e.getMessage());
        }
    }

    @Override
    public <T> T readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
}