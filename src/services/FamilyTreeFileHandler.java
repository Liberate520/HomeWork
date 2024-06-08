package services;

import models.FamilyTree;

import java.io.*;

/**
 * Класс для сохранения и загрузки генеалогического древа в файл.
 */
public class FamilyTreeFileHandler {

    /**
     * Метод для сохранения генеалогического древа в файл.
     *
     * @param familyTree Генеалогическое древо, которое нужно сохранить.
     * @param filename Путь к файлу, в который будет сохранено древо.
     * @throws IOException Если возникнет ошибка при записи в файл.
     */
    public void saveToFile(FamilyTree familyTree, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(familyTree);
        }
    }

    /**
     * Метод для загрузки генеалогического древа из файла.
     *
     * @param filename Путь к файлу, из которого будет загружено древо.
     * @return Генеалогическое древо, загруженное из файла.
     * @throws IOException Если возникнет ошибка при чтении из файла.
     * @throws ClassNotFoundException Если класс FamilyTree не найден.
     */
    public FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (FamilyTree) ois.readObject();
        }
    }
}