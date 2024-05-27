package services;

import models.FamilyTree;

import java.io.*;
import java.util.Objects;

/**
 * Класс для сохранения и загрузки генеалогического древа в файл.
 * Предоставляет методы для сохранения и загрузки древа.
 */
@SuppressWarnings("unused")
public class FamilyTreeFileHandler {
    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param familyTree Генеалогическое древо для сохранения
     * @param filename   Имя файла, в который будет сохранено древо
     */
    public static void saveToFile(FamilyTree familyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
            System.out.println("Генеалогическое древо успешно сохранено в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении генеалогического древа в файл: " + e.getMessage());
        }
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename Имя файла, из которого будет загружено древо
     * @return Загруженное генеалогическое древо
     */
    public static FamilyTree loadFromFile(String filename) {
        FamilyTree familyTree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            familyTree = (FamilyTree) ois.readObject();
            System.out.println("Генеалогическое древо успешно загружено из файла: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке генеалогического древа из файла: " + e.getMessage());
        }
        return familyTree;
    }
}