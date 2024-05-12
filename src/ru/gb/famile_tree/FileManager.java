package ru.gb.famile_tree;
import java.io.*;

public class FileManager {
    public static void writeToFile(String fileName, Serializable object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
            System.out.println("Объект успешно записан в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта в файл " + fileName + ": " + e.getMessage());
        }
    }

    public static Object readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = ois.readObject();
            System.out.println("Объект успешно прочитан из файла " + fileName);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении объекта из файла " + fileName + ": " + e.getMessage());
            return null;
        }
    }
}

