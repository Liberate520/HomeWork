package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.model.tools.writer.Writable;

import java.time.LocalDate;

/**
 * Класс Service предоставляет функциональность для управления генеалогическим древом.
 * Он включает методы для добавления новых членов семьи, установки родительских связей, установки супружеских связей,
 * а также для сохранения и загрузки данных генеалогического древа.
 */
public class Service {
    private FamilyTree<Human> tree;
    private Writable<FamilyTree<Human>> fileHandler;

    /**
     * Конструктор Service инициализирует объект с обработчиком файлов.
     *
     * @param fileHandler Объект, реализующий интерфейс Writable для работы с файлами.
     */
    public Service(Writable fileHandler) {
        this.fileHandler = fileHandler;
        tree = new FamilyTree<>();
    }

    /**
     * Читает генеалогическое древо из файла.
     *
     * @param path Путь к файлу.
     * @return Возвращает true, если чтение прошло успешно, иначе false.
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
     * Записывает текущее генеалогическое древо в файл.
     *
     * @param path Путь к файлу.
     * @return Возвращает true, если запись прошла успешно, иначе false.
     */
    public boolean write(String path) {
        return fileHandler.write(tree, path);
    }

    /**
     * Добавляет нового члена семьи в генеалогическое древо.
     *
     * @param name Имя нового члена семьи.
     * @param gender Пол нового члена семьи.
     * @param date Дата рождения нового члена семьи.
     * @return Всегда возвращает true.
     */
    public boolean addMember(String name, Gender gender, String date) {
        Human human = new Human(name, gender, date);
        tree.addMember(human);
        return true;
    }

    /**
     * Устанавливает дату смерти для члена семьи.
     *
     * @param personId ID члена семьи.
     * @param dod Дата смерти.
     */
    public void setDeathDate(int personId, LocalDate dod) {
        Human human = tree.findById(personId);
        human.setDod(dod);
    }

    /**
     * Устанавливает родительскую связь между двумя членами семьи.
     *
     * @param memberId ID члена семьи.
     * @param parentId ID родителя.
     */
    public void setParent(int memberId, int parentId) {
        Human human = tree.findById(memberId);
        human.addParent(tree.findById(parentId));
    }

    /**
     * Устанавливает супружеские отношения между двумя членами семьи.
     *
     * @param firstMemberId ID первого члена семьи.
     * @param secondMemberId ID второго члена семьи.
     * @param spouseStatus Статус супружеских отношений.
     */
    public void setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        Human human = tree.findById(firstMemberId);
        human.addSpouse(tree.findById(secondMemberId), spouseStatus);
    }

    /**
     * Проверяет наличие члена семьи по его ID.
     *
     * @param id ID члена семьи.
     * @return Возвращает true, если член семьи найден, иначе false.
     */
    public boolean checkById(int id) {
        return tree.checkById(id);
    }

    /**
     * Возвращает строковое представление генеалогического древа.
     *
     * @return Строковое представление генеалогического древа.
     */
    public String getAboutFamily() {
        return tree.toString();
    }

    /**
     * Сортирует генеалогическое древо по возрасту и возвращает его строковое представление.
     *
     * @return Строковое представление отсортированного по возрасту генеалогического древа.
     */
    public String sortTreeByAge() {
        tree.sortByAge();
        return tree.toString();
    }

    /**
     * Сортирует генеалогическое древо по имени и возвращает его строковое представление.
     *
     * @return Строковое представление отсортированного по имени генеалогического древа.
     */
    public String sortTreeByName() {
        tree.sortByName();
        return tree.toString();
    }
}
