package models;

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
    private static final long serialVersionUID = 1L;
    private List<T> familyMembers;

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
     * Добавляет все объекты из списка в генеалогическое древо.
     *
     * @param members список объектов для добавления
     */
    public void addAll(List<T> members) {
        familyMembers.addAll(members);
    }

    /**
     * Очищает генеалогическое древо.
     */
    public void clear() {
        familyMembers.clear();
    }

    /**
     * Возвращает список объектов в генеалогическом древе.
     *
     * @return список объектов
     */
    public List<T> getFamilyMembers() {
        return familyMembers;
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
        familyMembers.sort((Comparator<? super T>) Comparator.comparing(Human::getName));
    }

    /**
     * Сортирует объекты в генеалогическом древе по дате рождения.
     */
    public void sortByBirthDate() {
        familyMembers.sort((Comparator<? super T>) Comparator.comparing(Human::getBirthDate));
    }
}