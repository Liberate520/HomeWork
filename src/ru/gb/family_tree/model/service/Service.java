package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.model.tools.writer.FileHandler;

import java.time.LocalDate;

/**
 * Класс Service предоставляет методы для управления семейным древом.
 */
public class Service {
    private FamilyTree<Human> tree;
    private FileHandler<Human> fileHandler = new FileHandler<>();

    /**
     * Конструктор по умолчанию. Создает пустое семейное древо.
     */
    public Service() {
        tree = new FamilyTree<>();
    }

    /**
     * Читает семейное древо из файла.
     *
     * @param path путь к файлу
     * @return true, если чтение успешно, иначе false
     */
    public boolean read(String path) {
        FamilyTree<Human> treeRead = fileHandler.read(path);
        if (treeRead.equals(null)) {
            return false;
        }
        tree = treeRead;
        return true;
    }

    /**
     * Записывает семейное древо в файл.
     *
     * @param path путь к файлу
     * @return true, если запись успешна, иначе false
     */
    public boolean write(String path) {
        return fileHandler.write(tree, path);
    }

    /**
     * Добавляет нового члена в семейное древо.
     *
     * @param name   имя нового члена
     * @param gender пол нового члена
     * @param date   дата рождения нового члена в формате "yyyy-MM-dd"
     * @return true, если член успешно добавлен
     */
    public boolean addMember(String name, Gender gender, String date) {
        Human human = new Human(name, gender, date);
        tree.addMember(human);
        return true;
    }

    /**
     * Устанавливает дату смерти члена семейного древа.
     *
     * @param personId идентификатор члена семейного древа
     * @param dod      дата смерти
     */
    public void setDeathDate(int personId, LocalDate dod) {
        Human human = tree.findById(personId);
        human.setDod(dod);
    }

    /**
     * Устанавливает родителя для члена семейного древа.
     *
     * @param memberId идентификатор члена семейного древа
     * @param parentId идентификатор родителя
     */
    public void setParent(int memberId, int parentId) {
        Human human = tree.findById(memberId);
        human.addParent(tree.findById(parentId));
    }

    /**
     * Устанавливает супруга для члена семейного древа.
     *
     * @param firstMemberId  идентификатор первого члена семейного древа
     * @param secondMemberId идентификатор второго члена семейного древа
     * @param spouseStatus   статус супруга
     */
    public void setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        Human human = tree.findById(firstMemberId);
        human.addSpouse(tree.findById(secondMemberId), spouseStatus);
    }

    /**
     * Проверяет наличие члена семейного древа по идентификатору.
     *
     * @param id идентификатор члена семейного древа
     * @return true, если член существует, иначе false
     */
    public boolean checkById(int id) {
        return tree.checkById(id);
    }

    /**
     * Возвращает информацию о семейном древе.
     *
     * @return информация о семейном древе
     */
    public String getAboutFamily() {
        return tree.toString();
    }

    /**
     * Сортирует семейное древо по возрасту и возвращает его информацию.
     *
     * @return информация о отсортированном по возрасту семейном древе
     */
    public String sortTreeByAge() {
        tree.sortByAge();
        return tree.toString();
    }

    /**
     * Сортирует семейное древо по имени и возвращает его информацию.
     *
     * @return информация о отсортированном по имени семейном древе
     */
    public String sortTreeByName() {
        tree.sortByName();
        return tree.toString();
    }
}
