package services;

import models.Human;
import models.FamilyTree;
import java.io.IOException;

/**
 * Интерфейс FamilyTreeService определяет методы для управления генеалогическим древом и работы с файлами.
 * Он обеспечивает абстракцию для работы с генеалогическим древом и позволяет использовать различные реализации.
 */
public interface FamilyTreeService {
    /**
     * Добавляет человека в генеалогическое древо.
     *
     * @param human человек, который добавляется в древо
     */
    void addHuman(Human human);

    /**
     * Сортирует генеалогическое древо по имени.
     */
    void sortByName();

    /**
     * Сортирует генеалогическое древо по дате рождения.
     */
    void sortByBirthDate();

    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param filename имя файла для сохранения
     * @throws IOException если возникает ошибка ввода-вывода при сохранении файла
     */
    void saveToFile(String filename) throws IOException;

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла для загрузки
     * @throws IOException            если возникает ошибка ввода-вывода при загрузке файла
     * @throws ClassNotFoundException если возникает ошибка при десериализации объекта
     */
    void loadFromFile(String filename) throws IOException, ClassNotFoundException;

    /**
     * Возвращает генеалогическое древо.
     *
     * @return генеалогическое древо
     */
    FamilyTree<Human> getFamilyTree();
}