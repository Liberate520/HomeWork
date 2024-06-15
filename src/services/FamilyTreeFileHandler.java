package services;

import models.FamilyTree;

import java.io.*;

/**
 * Класс FamilyTreeFileHandler обрабатывает файлы с генеалогическими древами.
 * Он обеспечивает сохранение и загрузку генеалогических древ в файлы.
 */
public class FamilyTreeFileHandler {
    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param familyTree генеалогическое древо
     * @param filename   имя файла
     * @param <T>        тип объектов в генеалогическом древе
     */
    public <T extends Serializable & Comparable<T>> void saveFamilyTree(FamilyTree<T> familyTree, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(familyTree);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла
     * @param <T>       тип объектов в генеалогическом древе
     * @return загруженное генеалогическое древо
     */
    @SuppressWarnings("unchecked")
    public <T extends Serializable & Comparable<T>> FamilyTree<T> loadFamilyTree(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
            return new FamilyTree<>();
        }
    }
}
