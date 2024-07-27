package ru.gb.family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//public interface TreeNode<T> extends Serializable {
//    void setId(long id);
//    long getId();
//    T getFather();
//    T getMother();
//    boolean addChild(T human);
//    boolean addParent(T human);
//    String getName();
//    LocalDate getDeathDate();
//   LocalDate getBirthDate();
//   List<T> getParents();
//    List<T> getChildren();
//    T getSpouse();
 //   void setSpouse(T human);
//}
/**
 * Интерфейс для узла дерева семейных связей.
 * @param <T> тип элемента дерева (чаще всего Human).
 */
public interface TreeNode<T> extends Serializable {

    /**
     * Устанавливает уникальный идентификатор для узла.
     * @param id уникальный идентификатор.
     */
    void setId(long id);

    /**
     * Возвращает уникальный идентификатор узла.
     * @return уникальный идентификатор.
     */
    long getId();

    /**
     * Возвращает отца данного узла.
     * @return отец или null, если не установлен.
     */
    T getFather();

    /**
     * Возвращает мать данного узла.
     * @return мать или null, если не установлена.
     */
    T getMother();

    /**
     * Добавляет ребенка к данному узлу.
     * @param human ребенок, добавляемый к родителю.
     * @return true, если добавление прошло успешно, иначе false.
     */
    boolean addChild(T human);

    /**
     * Добавляет родителя к данному узлу.
     * @param human родитель, добавляемый к ребенку.
     * @return true, если добавление прошло успешно, иначе false.
     */
    boolean addParent(T human);

    /**
     * Возвращает имя данного узла.
     * @return имя.
     */
    String getName();

    /**
     * Возвращает дату смерти.
     * @return дата смерти или null, если узел еще жив.
     */
    LocalDate getDeathDate();

    /**
     * Возвращает дату рождения.
     * @return дата рождения.
     */
    LocalDate getBirthDate();

    /**
     * Возвращает список родителей данного узла.
     * @return список родителей.
     */
    List<T> getParents();

    /**
     * Возвращает список детей данного узла.
     * @return список детей.
     */
    List<T> getChildren();
}