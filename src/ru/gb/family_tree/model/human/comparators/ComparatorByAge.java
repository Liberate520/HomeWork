package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Класс ComparatorByAge предоставляет способ сравнения элементов семейного дерева по их возрасту.
 *
 * @param <E> тип элемента семейного дерева, который наследует {@link FamilyTreeElement}
 */
public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного дерева по их возрасту.
     *
     * @param o1 первый элемент для сравнения
     * @param o2 второй элемент для сравнения
     * @return отрицательное значение, если первый элемент младше второго,
     *         положительное значение, если первый элемент старше второго,
     *         или 0, если их возраст одинаков
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
