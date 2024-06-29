package services;

import models.Human;
import models.FamilyTree;
import java.io.IOException;

/**
 * Класс FamilyTreeService отвечает за управление генеалогическим древом и работу с файлами.
 */
public class FamilyTreeService {
    private final FamilyTree<Human> familyTree;
    private final FamilyTreeFileHandler<Human> fileHandler;

    /**
     * Конструктор класса FamilyTreeService.
     */
    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FamilyTreeFileHandler<>();
    }

    /**
     * Добавляет человека в генеалогическое древо.
     *
     * @param human человек, который добавляется в древо
     */
    public void addHuman(Human human) {
        familyTree.add(human);
    }

    /**
     * Сортирует генеалогическое древо по имени.
     */
    public void sortByName() {
        familyTree.sortByName();
    }

    /**
     * Сортирует генеалогическое древо по дате рождения.
     */
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param filename имя файла для сохранения
     * @throws IOException если возникает ошибка ввода-вывода при сохранении файла
     */
    public void saveToFile(String filename) {
        try {
            fileHandler.saveFamilyTree(familyTree, filename);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла для загрузки
     * @throws IOException            если возникает ошибка ввода-вывода при загрузке файла
     * @throws ClassNotFoundException если возникает ошибка при десериализации объекта
     */
    public void loadFromFile(String filename) {
        try {
            familyTree.clear();
            familyTree.addAll(fileHandler.loadFamilyTree(filename));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ошибка при загрузке файла: " + e.getMessage());
        }
    }

    /**
     * Возвращает генеалогическое древо.
     *
     * @return генеалогическое древо
     */
    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }
}
