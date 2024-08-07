package ru.gb.family_tree.model.family_tree.iterators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Iterator;
import java.util.List;

/**
 * Итератор для обхода элементов семейного дерева.
 *
 * @param <E> Тип элементов, наследуемый от FamilyTreeElement.
 */
public class FamilyTreeIterator<E extends FamilyTreeElement<E>> implements Iterator<E> {
    private int idx;
    private List<E> familyTreeList;

    /**
     * Конструктор инициализирует итератор списком элементов семейного дерева.
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
     * @return true, если существует следующий элемент, иначе false.
     */
    @Override
    public boolean hasNext() {
        return familyTreeList.size() > idx;
    }

    /**
     * Возвращает следующий элемент в списке.
     *
     * @return следующий элемент в списке.
     */
    @Override
    public E next() {
        return familyTreeList.get(idx++);
    }
}
