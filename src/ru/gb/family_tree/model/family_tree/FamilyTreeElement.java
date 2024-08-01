package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс для элементов генеалогического древа.
 *
 * @param <T> Тип элемента, который расширяет интерфейс FamilyTreeElement.
 */
public interface FamilyTreeElement<T> extends Serializable {

    /**
     * Возвращает идентификатор элемента.
     *
     * @return идентификатор элемента.
     */
    long getId();

    /**
     * Устанавливает идентификатор элемента.
     *
     * @param id идентификатор элемента.
     */
    void setId(long id);

    /**
     * Печатает идентификатор элемента.
     */
    void PrintId();

    /**
     * Возвращает имя элемента.
     *
     * @return имя элемента.
     */
    String getName();

    /**
     * Устанавливает имя элемента.
     *
     * @param name имя элемента.
     */
    void setName(String name);

    /**
     * Печатает имя элемента.
     */
    void PrintName();

    /**
     * Возвращает дату рождения элемента.
     *
     * @return дата рождения элемента.
     */
    LocalDate getDob();

    /**
     * Устанавливает дату рождения элемента.
     *
     * @param dob дата рождения элемента.
     */
    void setDob(LocalDate dob);

    /**
     * Печатает дату рождения элемента.
     */
    void PrintDob();

    /**
     * Возвращает дату смерти элемента.
     *
     * @return дата смерти элемента.
     */
    LocalDate getDod();

    /**
     * Устанавливает дату смерти элемента.
     *
     * @param dod дата смерти элемента.
     */
    void setDod(LocalDate dod);

    /**
     * Печатает дату смерти элемента.
     */
    void PrintDod();

    /**
     * Возвращает пол элемента.
     *
     * @return пол элемента.
     */
    Gender getGender();

    /**
     * Устанавливает пол элемента.
     *
     * @param gender пол элемента.
     */
    void setGender(Gender gender);

    /**
     * Печатает пол элемента.
     */
    void PrintGender();

    /**
     * Возвращает список детей элемента.
     *
     * @return список детей элемента.
     */
    List<T> getChildren();

    /**
     * Добавляет ребенка в список детей элемента.
     *
     * @param child ребенок, который будет добавлен.
     * @return true, если ребенок был успешно добавлен, иначе false.
     */
    boolean addChild(T child);

    /**
     * Возвращает информацию о детях элемента.
     *
     * @return информация о детях элемента.
     */
    String getChildrenAbout();

    /**
     * Печатает информацию о детях элемента.
     */
    void PrintChildren();

    /**
     * Возвращает мать элемента.
     *
     * @return мать элемента.
     */
    T getMother();

    /**
     * Устанавливает мать элемента.
     *
     * @param mother мать элемента.
     */
    void setMother(T mother);

    /**
     * Возвращает информацию о матери элемента.
     *
     * @return информация о матери элемента.
     */
    String getMotherAbout();

    /**
     * Печатает информацию о матери элемента.
     */
    void PrintMother();

    /**
     * Возвращает отца элемента.
     *
     * @return отец элемента.
     */
    T getFather();

    /**
     * Устанавливает отца элемента.
     *
     * @param father отец элемента.
     */
    void setFather(T father);

    /**
     * Возвращает информацию об отце элемента.
     *
     * @return информация об отце элемента.
     */
    String getFatherAbout();

    /**
     * Печатает информацию об отце элемента.
     */
    void PrintFather();

    /**
     * Добавляет родителя к элементу.
     *
     * @param parent родитель, который будет добавлен.
     */
    void addParent(T parent);

    /**
     * Возвращает супругов элемента и их статус.
     *
     * @return супруги элемента и их статус.
     */
    HashMap<T, SpouseStatus> getSpouse();

    /**
     * Добавляет супруга к элементу.
     *
     * @param spouse супруг, который будет добавлен.
     * @param status статус супруга.
     */
    void addSpouse(T spouse, SpouseStatus status);

    /**
     * Возвращает информацию о супругах элемента.
     *
     * @return информация о супругах элемента.
     */
    String getSpousesAbout();

    /**
     * Печатает информацию о супругах элемента.
     */
    void PrintSpouses();

    /**
     * Возвращает возраст элемента.
     *
     * @return возраст элемента.
     */
    int getAge();

    /**
     * Возвращает статус жизни элемента.
     *
     * @return статус жизни элемента.
     */
    String getLifeStatus();

    /**
     * Печатает возраст элемента.
     */
    void PrintAge();

    /**
     * Возвращает информацию об элементе.
     *
     * @return информация об элементе.
     */
    String getAbout();
}
