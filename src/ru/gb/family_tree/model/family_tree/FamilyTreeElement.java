package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс FamilyTreeElement представляет элемент семейного древа.
 *
 * @param <T> тип элемента семейного древа
 */
public interface FamilyTreeElement<T> extends Serializable {

    /**
     * Возвращает уникальный идентификатор элемента.
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
     * Возвращает имя элемента.
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
     * Возвращает дату рождения элемента.
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
     * Возвращает дату смерти элемента.
     *
     * @return дата смерти элемента
     */
    LocalDate getDod();

    /**
     * Устанавливает дату смерти элемента.
     *
     * @param dod дата смерти элемента
     */
    void setDod(LocalDate dod);

    /**
     * Возвращает пол элемента.
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
     * Возвращает список детей элемента.
     *
     * @return список детей элемента
     */
    List<T> getChildren();

    /**
     * Добавляет ребенка к элементу.
     *
     * @param child ребенок
     * @return true, если ребенок был успешно добавлен, иначе false
     */
    boolean addChild(T child);

    /**
     * Возвращает информацию о детях элемента.
     *
     * @return информация о детях элемента
     */
    String getChildrenAbout();

    /**
     * Возвращает мать элемента.
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
     * Возвращает информацию о матери элемента.
     *
     * @return информация о матери элемента
     */
    String getMotherAbout();

    /**
     * Возвращает отца элемента.
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
     * Возвращает информацию об отце элемента.
     *
     * @return информация об отце элемента
     */
    String getFatherAbout();

    /**
     * Добавляет родителя к элементу.
     *
     * @param parent родитель
     */
    void addParent(T parent);

    /**
     * Возвращает супруга(-у) элемента и их статус.
     *
     * @return супруга(-у) элемента и их статус
     */
    HashMap<T, SpouseStatus> getSpouse();

    /**
     * Добавляет супруга(-у) к элементу.
     *
     * @param spouse супруг(-а)
     * @param status статус супруга(-и)
     */
    void addSpouse(T spouse, SpouseStatus status);

    /**
     * Возвращает информацию о супругах элемента.
     *
     * @return информация о супругах элемента
     */
    String getSpousesAbout();

    /**
     * Возвращает возраст элемента.
     *
     * @return возраст элемента
     */
    int getAge();

    /**
     * Возвращает статус жизни элемента.
     *
     * @return статус жизни элемента
     */
    String getLifeStatus();

    /**
     * Возвращает информацию об элементе.
     *
     * @return информация об элементе
     */
    String getAbout();
}
