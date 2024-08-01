package ru.gb.family_tree.model.family_tree.iterators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Iterator;
import java.util.List;

/**
 * Итератор для обхода элементов семейного дерева.
 *
 * @param <E> Тип элемента семейного дерева, должен быть наследником FamilyTreeElement.
 */
public class FamilyTreeIterator<E extends FamilyTreeElement<E>> implements Iterator<E> {
    private int idx;
    private List<E> familyTreeList;

    /**
     * Конструктор итератора семейного дерева.
     *
     * @param familyTreeList Список элементов семейного дерева.
     */
    public FamilyTreeIterator(List<E> familyTreeList) {
        this.familyTreeList = familyTreeList;
        idx = 0;
    }

    /**
     * Проверяет, есть ли следующий элемент в списке.
     *
     * @return true, если следующий элемент существует, иначе false.
     */
    @Override
    public boolean hasNext() {
        return familyTreeList.size() > idx;
    }

    /**
     * Возвращает следующий элемент из списка.
     *
     * @return следующий элемент из списка.
     */
    @Override
    public E next() {
        return familyTreeList.get(idx++);
    }
}
