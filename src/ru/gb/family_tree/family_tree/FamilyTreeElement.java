package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс для элемента семейного дерева.
 *
 * @param <T> тип элемента семейного дерева
 */
public interface FamilyTreeElement<T> extends Serializable {

    /**
     * Получает идентификатор элемента.
     *
     * @return идентификатор элемента
     */
    long getId();

    /**
     * Устанавливает идентификатор элемента.
     *
     * @param id идентификатор элемента
     */
    void setId(long id);

    /**
     * Печатает идентификатор элемента.
     */
    void PrintId();

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
     * Печатает имя элемента.
     */
    void PrintName();

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
     * Печатает дату рождения элемента.
     */
    void PrintDob();

    /**
     * Получает дату смерти элемента.
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
     * Печатает дату смерти элемента.
     */
    void PrintDod();

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
     * Печатает пол элемента.
     */
    void PrintGender();

    /**
     * Получает список детей элемента.
     *
     * @return список детей элемента
     */
    List<T> getChildren();

    /**
     * Добавляет ребенка элементу.
     *
     * @param child ребенок, которого необходимо добавить
     * @return true, если ребенок успешно добавлен, иначе false
     */
    boolean addChild(T child);

    /**
     * Получает описание детей элемента.
     *
     * @return описание детей элемента
     */
    String getChildrenAbout();

    /**
     * Печатает описание детей элемента.
     */
    void PrintChildren();

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
     * Получает описание матери элемента.
     *
     * @return описание матери элемента
     */
    String getMotherAbout();

    /**
     * Печатает описание матери элемента.
     */
    void PrintMother();

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
     * Получает описание отца элемента.
     *
     * @return описание отца элемента
     */
    String getFatherAbout();

    /**
     * Печатает описание отца элемента.
     */
    void PrintFather();

    /**
     * Получает список супругов элемента с их статусами.
     *
     * @return список супругов элемента с их статусами
     */
    HashMap<T, SpouseStatus> getSpouse();

    /**
     * Добавляет супруга элементу.
     *
     * @param spouse супруг, которого необходимо добавить
     * @param status статус супруга
     * @return true, если супруг успешно добавлен, иначе false
     */
    boolean addSpouse(T spouse, SpouseStatus status);

    /**
     * Получает описание супругов элемента.
     *
     * @return описание супругов элемента
     */
    String getSpousesAbout();

    /**
     * Печатает описание супругов элемента.
     */
    void PrintSpouses();

    /**
     * Получает возраст элемента.
     *
     * @return возраст элемента
     */
    int getAge();

    /**
     * Получает статус жизни элемента.
     *
     * @return статус жизни элемента
     */
    String getLifeStatus();

    /**
     * Печатает возраст элемента.
     */
    void PrintAge();

    /**
     * Получает описание элемента.
     *
     * @return описание элемента
     */
    String getAbout();
}
