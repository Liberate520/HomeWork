package services;

import models.Human;
import models.FamilyTree;
import services.FamilyTreeService;
import services.FamilyTreeFileHandler;
import java.io.IOException;

/**
 * Класс FamilyTreeServiceImpl реализует интерфейс FamilyTreeService.
 * Он отвечает за управление генеалогическим древом и работу с файлами.
 */
public class FamilyTreeServiceImpl implements FamilyTreeService {
    private final FamilyTree<Human> familyTree;
    private final FamilyTreeFileHandler<Human> fileHandler;

    /**
     * Конструктор класса FamilyTreeServiceImpl.
     */
    public FamilyTreeServiceImpl() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FamilyTreeFileHandler<>();
    }

    /**
     * Добавляет человека в генеалогическое древо.
     *
     * @param human человек, который добавляется в древо
     */
    @Override
    public void addHuman(Human human) {
        familyTree.add(human);
    }

    /**
     * Сортирует генеалогическое древо по имени.
     */
    @Override
    public void sortByName() {
        familyTree.sortByName();
    }

    /**
     * Сортирует генеалогическое древо по дате рождения.
     */
    @Override
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param filename имя файла для сохранения
     * @throws IOException если возникает ошибка ввода-вывода при сохранении файла
     */
    @Override
    public void saveToFile(String filename) throws IOException {
        fileHandler.saveFamilyTree(familyTree, filename);
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла для загрузки
     * @throws IOException            если возникает ошибка ввода-вывода при загрузке файла
     * @throws ClassNotFoundException если возникает ошибка при десериализации объекта
     */
    @Override
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        familyTree.clear();
        familyTree.addAll(fileHandler.loadFamilyTree(filename));
    }

    /**
     * Возвращает генеалогическое древо.
     *
     * @return генеалогическое древо
     */
    @Override
    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }
}