package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс FamilyTree представляет генеалогическое древо.
 * Он содержит список людей и позволяет добавлять, удалять и получать людей из списка.
 * Класс параметризован, что позволяет использовать его для хранения объектов любого типа,
 * реализующего интерфейс Serializable.
 *
 * @param <T> тип объектов, которые будут храниться в генеалогическом древе
 */
public class FamilyTree<T extends Serializable> implements Iterable<T>, Serializable {
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
}