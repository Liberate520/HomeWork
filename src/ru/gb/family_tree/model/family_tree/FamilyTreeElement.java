package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.HashMap;

/**
 * Интерфейс FamilyTreeElement описывает основные методы, которые должен реализовать
 * каждый элемент семейного дерева. Элементы могут включать людей или другие сущности,
 * имеющие семейные связи.
 *
 * @param <T> тип элемента, наследующего интерфейс FamilyTreeElement
 */
public interface FamilyTreeElement<T> extends Serializable {

    /**
     * Получает уникальный идентификатор элемента.
     *
     * @return уникальный идентификатор элемента
     */
    long getId();

    /**
     * Устанавливает уникальный идентификатор элемента.
     *
     * @param id уникальный идентификатор элемента
     */
    void setId(long id);

    /**
     * Получает имя элемента.
     *
     * @return имя элемента
     */
    String getName();

    /**
     * Устанавливает имя элемента.
     *
     * @param name имя элемента
     */
    void setName(String name);

    /**
     * Получает дату рождения элемента.
     *
     * @return дата рождения элемента
     */
    LocalDate getDob();

    /**
     * Устанавливает дату рождения элемента.
     *
     * @param dob дата рождения элемента
     */
    void setDob(LocalDate dob);

    /**
     * Получает дату смерти элемента (если применимо).
     *
     * @return дата смерти элемента или null, если элемент еще жив
     */
    LocalDate getDod();

    /**
     * Устанавливает дату смерти элемента.
     *
     * @param dod дата смерти элемента
     */
    void setDod(LocalDate dod);

    /**
     * Получает пол элемента.
     *
     * @return пол элемента
     */
    Gender getGender();

    /**
     * Устанавливает пол элемента.
     *
     * @param gender пол элемента
     */
    void setGender(Gender gender);

    /**
     * Получает список детей элемента.
     *
     * @return список детей элемента
     */
    List<T> getChildren();

    /**
     * Добавляет ребенка к элементу.
     *
     * @param child ребенок, которого нужно добавить
     * @return true, если ребенок успешно добавлен, иначе false
     */
    boolean addChild(T child);

    /**
     * Возвращает информацию о детях элемента в виде строки.
     *
     * @return строковая информация о детях элемента
     */
    String getChildrenAbout();

    /**
     * Получает мать элемента.
     *
     * @return мать элемента
     */
    T getMother();

    /**
     * Устанавливает мать элемента.
     *
     * @param mother мать элемента
     */
    void setMother(T mother);

    /**
     * Возвращает информацию о матери элемента в виде строки.
     *
     * @return строковая информация о матери элемента
     */
    String getMotherAbout();

    /**
     * Получает отца элемента.
     *
     * @return отец элемента
     */
    T getFather();

    /**
     * Устанавливает отца элемента.
     *
     * @param father отец элемента
     */
    void setFather(T father);

    /**
     * Возвращает информацию об отце элемента в виде строки.
     *
     * @return строковая информация об отце элемента
     */
    String getFatherAbout();

    /**
     * Добавляет родителя к элементу.
     *
     * @param parent родитель, которого нужно добавить
     */
    void addParent(T parent);

    /**
     * Получает список супругов элемента и их статус (супруг/супруга или бывший супруг/супруга).
     *
     * @return карта супругов и их статусов
     */
    HashMap<T, SpouseStatus> getSpouse();

    /**
     * Добавляет супруга к элементу с указанным статусом.
     *
     * @param spouse супруг, которого нужно добавить
     * @param status статус супруга (действующий или бывший)
     */
    void addSpouse(T spouse, SpouseStatus status);

    /**
     * Возвращает информацию о супругах элемента в виде строки.
     *
     * @return строковая информация о супругах элемента
     */
    String getSpousesAbout();

    /**
     * Возвращает текущий возраст элемента.
     *
     * @return возраст элемента
     */
    int getAge();

    /**
     * Возвращает информацию о жизненном статусе элемента (жив или умер).
     *
     * @return строковая информация о жизненном статусе элемента
     */
    String getLifeStatus();

    /**
     * Возвращает полную информацию об элементе в виде строки.
     *
     * @return строковое представление информации об элементе
     */
    String getAbout();

}
