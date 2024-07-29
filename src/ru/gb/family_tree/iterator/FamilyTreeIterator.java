package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

/**
 * Итератор для обхода списка объектов {@link Human} в семейном дереве.
 * <p>
 * Этот итератор позволяет последовательно проходить через элементы списка {@code familyTreeList},
 * предоставляя доступ к каждому объекту {@link Human} в порядке их следования.
 * </p>
 */
public class FamilyTreeIterator implements Iterator<Human> {
    private int idx;
    private List<Human> familyTreeList;

    /**
     * Конструктор для инициализации итератора.
     *
     * @param familyTreeList список объектов {@link Human}, по которому будет осуществляться итерация
     */
    public FamilyTreeIterator(List<Human> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    /**
     * Проверяет, есть ли еще элементы для итерации.
     *
     * @return {@code true}, если в списке {@code familyTreeList} остались элементы для итерации,
     *         {@code false} в противном случае
     */
    @Override
    public boolean hasNext() {
        return familyTreeList.size() > idx;
    }

    /**
     * Возвращает следующий элемент в последовательности итерации.
     *
     * @return следующий объект {@link Human} из списка {@code familyTreeList}
     * @throws java.util.NoSuchElementException если в списке больше нет элементов
     */
    @Override
    public Human next() {
        return familyTreeList.get(idx++);
    }
}
