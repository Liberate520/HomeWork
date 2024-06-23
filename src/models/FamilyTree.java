package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Класс FamilyTree представляет генеалогическое древо.
 * Он содержит список объектов и позволяет добавлять, удалять и получать объекты из списка.
 * Класс параметризован, что позволяет использовать его для хранения объектов любого типа,
 * реализующего интерфейсы Serializable и Comparable.
 *
 * @param <T> тип объектов, которые будут храниться в генеалогическом древе
 */
public class FamilyTree<T extends Serializable & Comparable<T>> implements Iterable<T>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final List<T> familyMembers;

    /**
     * Конструктор класса FamilyTree.
     */
    public FamilyTree() {
        this.familyMembers = new ArrayList<>();
    }

    /**
     * Добавляет объект в генеалогическое древо.
     *
     * @param member объект, который добавляется в древо
     */
    public void add(T member) {
        familyMembers.add(member);
    }

    /**
     * Возвращает итератор для перебора объектов в генеалогическом древе.
     * Реализация интерфейса Iterable позволяет использовать древо в циклах for-each.
     *
     * @return итератор для перебора объектов
     */
    @Override
    public Iterator<T> iterator() {
        return familyMembers.iterator();
    }

    /**
     * Сортирует объекты в генеалогическом древе по имени в алфавитном порядке.
     */
    public void sortByName() {
        familyMembers.sort(Comparator.comparing((T t) -> ((Human)t).getName()));
    }

    /**
     * Сортирует объекты в генеалогическом древе по дате рождения.
     */
    public void sortByBirthDate() {
        familyMembers.sort(Comparator.comparing((T t) -> ((Human)t).getBirthDate()));
    }
}