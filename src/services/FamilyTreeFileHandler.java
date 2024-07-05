package services;

import models.FamilyTree;

import java.io.*;

/**
 * Класс FamilyTreeFileHandler обрабатывает файлы с генеалогическими древами.
 * Он обеспечивает сохранение и загрузку генеалогических древ в файлы.
 */
public class FamilyTreeFileHandler<T extends Serializable & Comparable<T>> {
    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param familyTree генеалогическое древо
     * @param filename   имя файла
     * @throws IOException если возникает ошибка ввода-вывода при сохранении файла
     */
    public void saveFamilyTree(FamilyTree<T> familyTree, String filename) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(familyTree);
        }
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла
     * @return загруженное генеалогическое древо
     * @throws IOException            если возникает ошибка ввода-вывода при загрузке файла
     * @throws ClassNotFoundException если возникает ошибка при десериализации объекта
     */
    @SuppressWarnings("unchecked")
    public FamilyTree<T> loadFamilyTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) inputStream.readObject();
        }
    }
}