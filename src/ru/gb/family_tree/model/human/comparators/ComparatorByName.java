package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Класс ComparatorByName предоставляет способ сравнения элементов семейного дерева по их имени.
 *
 * @param <E> тип элемента семейного дерева, который наследует {@link FamilyTreeElement}
 */
public class ComparatorByName<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного дерева по их имени в лексикографическом порядке.
     *
     * @param o1 первый элемент для сравнения
     * @param o2 второй элемент для сравнения
     * @return отрицательное значение, если имя первого элемента предшествует имени второго в лексикографическом порядке,
     *         положительное значение, если имя первого элемента следует за именем второго,
     *         или 0, если их имена одинаковы
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
