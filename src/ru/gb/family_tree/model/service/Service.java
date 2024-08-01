package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.model.tools.writer.FileHandler;

import java.time.LocalDate;

/**
 * Сервисный класс для работы с семейным деревом.
 * <p>
 * Этот класс предоставляет методы для управления членами семьи,
 * а также для чтения и записи данных в файл.
 * </p>
 */
public class Service {
    private FamilyTree<Human> tree;
    private FileHandler<Human> fileHandler = new FileHandler<>();

    /**
     * Конструктор, который инициализирует пустое семейное дерево.
     */
    public Service() {
        tree = new FamilyTree<>();
    }

    /**
     * Чтение семейного дерева из файла.
     * <p>
     * Если файл успешно прочитан, семейное дерево обновляется и метод возвращает {@code true}.
     * В противном случае метод возвращает {@code false}.
     * </p>
     *
     * @param path путь к файлу
     * @return {@code true} если чтение прошло успешно, иначе {@code false}
     */
    public boolean read(String path) {
        FamilyTree<Human> treeRead = fileHandler.read(path);
        if (treeRead == null) {
            return false;
        }
        tree = treeRead;
        return true;
    }

    /**
     * Запись семейного дерева в файл.
     *
     * @param path путь к файлу
     * @return {@code true} если запись прошла успешно, иначе {@code false}
     */
    public boolean write(String path) {
        return fileHandler.write(tree, path);
    }

    /**
     * Добавление нового члена семьи.
     *
     * @param name имя нового члена семьи
     * @param gender пол нового члена семьи
     * @param date дата рождения нового члена семьи в формате "yyyy-MM-dd"
     * @return {@code true} если член семьи был успешно добавлен
     */
    public boolean addMember(String name, Gender gender, String date) {
        Human human = new Human(name, gender, date);
        tree.addMember(human);
        return true;
    }

    /**
     * Установка даты смерти для члена семьи.
     *
     * @param personId идентификатор члена семьи
     * @param dod дата смерти
     */
    public void setDeathDate(int personId, LocalDate dod) {
        Human human = tree.findById(personId);
        human.setDod(dod);
    }

    /**
     * Установка родителя для члена семьи.
     *
     * @param memberId идентификатор члена семьи
     * @param parentId идентификатор родителя
     */
    public void setParent(int memberId, int parentId) {
        Human human = tree.findById(memberId);
        human.addParent(tree.findById(parentId));
    }

    /**
     * Установка супруга/супруги для члена семьи.
     *
     * @param firstMemberId идентификатор первого члена семьи
     * @param secondMemberId идентификатор второго члена семьи
     * @param spouseStatus статус супружеских отношений
     */
    public void setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        Human human = tree.findById(firstMemberId);
        human.addSpouse(tree.findById(secondMemberId), spouseStatus);
    }

    /**
     * Проверка существования члена семьи по идентификатору.
     *
     * @param id идентификатор члена семьи
     * @return {@code true} если член семьи с указанным идентификатором существует, иначе {@code false}
     */
    public boolean checkById(int id) {
        return tree.checkById(id);
    }

    /**
     * Получение строки, представляющей семейное дерево.
     *
     * @return строковое представление семейного дерева
     */
    public String getAboutFamily() {
        return tree.toString();
    }

    /**
     * Сортировка членов семьи по возрасту и получение строки, представляющей отсортированное дерево.
     *
     * @return строковое представление семейного дерева, отсортированного по возрасту
     */
    public String sortTreeByAge() {
        tree.sortByAge();
        return tree.toString();
    }

    /**
     * Сортировка членов семьи по имени и получение строки, представляющей отсортированное дерево.
     *
     * @return строковое представление семейного дерева, отсортированного по имени
     */
    public String sortTreeByName() {
        tree.sortByName();
        return tree.toString();
    }
}
