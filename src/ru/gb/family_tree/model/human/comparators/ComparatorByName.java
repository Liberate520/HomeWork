package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Класс ComparatorByName сравнивает элементы семейного древа по имени.
 *
 * @param <E> тип элемента семейного древа, реализующего интерфейс FamilyTreeElement
 */
public class ComparatorByName<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного древа по их имени.
     *
     * @param o1 первый элемент семейного древа
     * @param o2 второй элемент семейного древа
     * @return отрицательное целое число, ноль или положительное целое число, если имя
     *         первого элемента меньше, равно или больше имени второго элемента соответственно
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
